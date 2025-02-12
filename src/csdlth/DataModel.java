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

public class DataModel {

    /**
     * Hàm lấy dữ liệu từ một URL thông qua HTTP Request và trả về dữ liệu dưới dạng ArrayList.
     * @param url Địa chỉ URL để lấy dữ liệu.
     * @return ArrayList<ArrayList<String>>: Dữ liệu thu thập từ URL, dạng bảng.
     * @throws IOException Nếu có lỗi khi đọc dữ liệu.
     * @throws InterruptedException Nếu có lỗi khi gửi yêu cầu HTTP.
     * @throws JSONException Nếu có lỗi khi xử lý dữ liệu JSON.
     */
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

    /**
     * Hàm chuyển ArrayList dữ liệu thành DefaultTableModel cho JTable.
     * @param tenCot Mảng tên các cột của bảng.
     * @param d Dữ liệu dạng ArrayList cần hiển thị.
     * @return DefaultTableModel: Mô hình bảng dữ liệu.
     */
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

    /**
     * Hàm thêm dữ liệu vào DefaultTableModel đã có sẵn.
     * @param tableModel Mô hình bảng hiện tại.
     * @param d Dữ liệu cần thêm vào bảng.
     * @param tenCot Mảng tên cột.
     * @return DefaultTableModel: Mô hình bảng đã được cập nhật.
     */
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

    /**
     * Hàm lấy dữ liệu từ các IP trong file và hiển thị lên JTable.
     * @param f File chứa danh sách các IP.
     * @param tableModel Mô hình bảng hiện tại để cập nhật.
     * @param tblResult JTable để hiển thị kết quả.
     * @param txtError JTextArea để hiển thị thông báo lỗi.
     * @param tenCot Mảng tên các cột.
     */
    public void getDataSanPham(File f, DefaultTableModel tableModel, JTable tblResult,
                            JTextArea txtError, String[] tenCot) {
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
        String url = "http://" + ip;
        DataModel db = new DataModel();

        try {
            // Cố gắng lấy dữ liệu từ URL
            ArrayList<ArrayList<String>> data = db.get(url);

            // Thêm dữ liệu vào table model
            DefaultTableModel updatedTableModel = db.addTableModel(tableModel, data, tenCot);
            tblResult.setModel(updatedTableModel);

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

    }

