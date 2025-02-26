// Thư viện sử dụng
package csdlth;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class SanPhamModel {

    // Hàm lấy dữ liệu từ một URL thông qua HTTP Request và trả về dữ liệu dưới dạng ArrayList.
     
    public ArrayList<ArrayList<String>> get(String url)
            throws IOException, InterruptedException, JSONException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request;
        request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Chuyển dữ liệu từ JSON thành ArrayList
        JSONArray ja = new JSONArray(new String(response.body().getBytes(), "utf-8"));
        ArrayList<ArrayList<String>> datalist = new ArrayList<>();

        // Duyệt qua các dòng trong mảng JSON và chuyển thành ArrayList
        for (int i = 0; i < ja.length(); i++) {
            String s = ja.get(i).toString();
            s = s.substring(1, s.length() - 1);
            String[] as = s.split(",");
            ArrayList<String> row = new ArrayList<>();

            for (int j = 0; j < as.length; j++) {
                as[j] = as[j].replace('"', ' '); // Loại bỏ dấu ngoặc kép
                row.add(as[j]);
            }
            datalist.add(row);
        }
        return datalist;
    }

    //Hàm chuyển ArrayList dữ liệu thành DefaultTableModel cho JTable.
    
    public DefaultTableModel getTableModel(String[] tenCot, ArrayList<ArrayList<String>> d) {
        DefaultTableModel tableModel = new DefaultTableModel(tenCot, 0);
        for (int i = 0; i < d.size(); i++) {
            Object o[] = new Object[tenCot.length];
            for (int j = 0; j < d.get(i).size(); j++) {
                o[j] = d.get(i).get(j);
            }
            tableModel.addRow(o);
        }
        return tableModel;
    }

    //Hàm thêm dữ liệu vào DefaultTableModel đã có sẵn.
     
    public DefaultTableModel addTableModel(DefaultTableModel tableModel,
            ArrayList<ArrayList<String>> d,
            String tenCot[]) {
        if (tableModel == null) {
            tableModel = new DefaultTableModel(tenCot, 0);
        }
        for (int i = 0; i < d.size(); i++) {
            Object o[] = new Object[tenCot.length];
            for (int j = 0; j < d.get(i).size(); j++) {
                o[j] = d.get(i).get(j);
            }
            tableModel.addRow(o);
        }
        return tableModel;
    }

    //Hàm lấy dữ liệu từ các IP trong file và hiển thị lên JTable.
 
    public void getDataSanPhamvaLoadTable(File f, DefaultTableModel tableModel, JTable tblResult,
            JTextArea txtError, String[] tenCot, String manh) {
        if (f == null) {
            return;
        }

        // List để chứa các IP lấy từ file
        ArrayList<String> aIP = new ArrayList<>();

        // Đọc file một cách an toàn với try-with-resources
        try (BufferedReader bf = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = bf.readLine()) != null) {
                aIP.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Duyệt qua các IP và cố gắng kết nối lấy dữ liệu
        for (String ip : aIP) {
            String url = "http://" + ip + "/" + "sanpham/sanpham" + manh;
            SanPhamModel db = new SanPhamModel();

            try {
                // Cố gắng lấy dữ liệu từ URL
                ArrayList<ArrayList<String>> data = db.get(url);

                // Thêm dữ liệu vào table model
                DefaultTableModel updatedTableModel = db.addTableModel(tableModel, data, tenCot);
                tblResult.setModel(updatedTableModel);
                txtError.setText("succed:" + url);

            } catch (ConnectException e1) {
                // Nếu không thể kết nối, hiển thị lỗi trong JTextArea
                String errorMessage = txtError.getText();
                errorMessage += "\nKhông thể kết nối tới " + url + " (IP tắt hoặc không tồn tại)";
                txtError.setText(errorMessage);

            } catch (IOException e2) {
                // Nếu có lỗi đọc dữ liệu từ URL
                String errorMessage = txtError.getText();
                errorMessage += "\nLỗi khi đọc dữ liệu từ " + url;
                txtError.setText(errorMessage);

            } catch (Exception e3) {
                // Các lỗi khác
                e3.printStackTrace();
            }
        }
    }

    // Hàm lấy dữ liệu từ một URL thông qua HTTP Request và trả về dữ liệu dưới dạng ArrayList.
    public ArrayList<ArrayList<String>> getDataFromManh(File f, JTextArea txtError, String manh) {
        if (f == null) {
            return null;
        }

        ArrayList<ArrayList<String>> data = new ArrayList<>();
        // List để chứa các IP lấy từ file
        ArrayList<String> aIP = new ArrayList<>();

        // Đọc file một cách an toàn với try-with-resources
        try (BufferedReader bf = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = bf.readLine()) != null) {
                aIP.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Duyệt qua các IP và cố gắng kết nối lấy dữ liệu
        for (String ip : aIP) {
            String url = "http://" + ip + "/" + "sanpham/sanpham" + manh;
            SanPhamModel db = new SanPhamModel();

            try {
                // Cố gắng lấy dữ liệu từ URL
                data = db.get(url);

            } catch (ConnectException e1) {
                // Nếu không thể kết nối, hiển thị lỗi trong JTextArea
                String errorMessage = txtError.getText();
                errorMessage += "\nKhông thể kết nối tới " + url + " (IP tắt hoặc không tồn tại)";
                txtError.setText(errorMessage);

            } catch (IOException e2) {
                // Nếu có lỗi đọc dữ liệu từ URL
                String errorMessage = txtError.getText();
                errorMessage += "\nLỗi khi đọc dữ liệu từ " + url;
                txtError.setText(errorMessage);

            } catch (Exception e3) {
                // Các lỗi khác
                e3.printStackTrace();
            }
        }
        return data;
    }

    // Kết dọc 2 bảng
    public ArrayList<ArrayList<String>> Combie2Table(ArrayList<ArrayList<String>> a, ArrayList<ArrayList<String>> b) {
        ArrayList<ArrayList<String>> combinedData = new ArrayList<>();

        for (ArrayList<String> rowA : a) {
            String keyA = rowA.get(0); // Get the value in the first column of list a
            boolean foundMatch = false;

            for (ArrayList<String> rowB : b) {
                String keyB = rowB.get(0); // Get the value in the first column of list b

                if (keyA.equals(keyB)) {
                    ArrayList<String> combinedRow = new ArrayList<>(rowA); // Start with rowA
                    combinedRow.addAll(rowB.subList(1, rowB.size())); // Add the remaining columns from rowB (excluding
                                                                      // first column)
                    combinedData.add(combinedRow); // Add the merged row to the result list
                    foundMatch = true;
                    break; // Stop searching once we find a match
                }
            }

            // If no match was found in list b, add the row from a as is
            if (!foundMatch) {
                combinedData.add(rowA);
            }
        }

        for (ArrayList<String> rowB : b) {
            String keyB = rowB.get(0);
            boolean alreadyAdded = false;

            // Check if the row from b was already added
            for (ArrayList<String> rowA : combinedData) {
                if (rowA.get(0).equals(keyB)) {
                    alreadyAdded = true;
                    break;
                }
            }

            // If not already added, we add the row from b
            if (!alreadyAdded) {
                combinedData.add(rowB);
            }
        }

        return combinedData;
    }

    // Kết ngang
    public ArrayList<ArrayList<String>> GhepPhanManhNgang(ArrayList<ArrayList<String>> a, ArrayList<ArrayList<String>> b){ 
        ArrayList<ArrayList<String>> c = new ArrayList<>();
        for(int i=0;i<a.size();i++){
        c.add(a.get(i));
        }
        for(int j=0;j<b.size();j++){
        c.add(b.get(j));
        } 
        return c;
    }
 

}
