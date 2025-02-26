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
import javax.swing.JTextArea;


public class KhoHangModel {

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

    public ArrayList<ArrayList<String>> getDataFromManh(File f, JTextArea txtError) {
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
            String url = "http://" + ip + "/" + "khohang";
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

}