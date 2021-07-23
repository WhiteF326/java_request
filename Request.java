import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Request {
  public static final int METHOD_GET = 0;
  public static final int METHOD_POST = 1;

  public void req(String urlstr, int method, String param){
    switch(method){
      case METHOD_GET:
        try {
          URL url = new URL(urlstr);
          try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))){
            for(String line; (line = reader.readLine()) != null;) {
              System.out.println(line);
            }
          } catch (IOException e){
            e.printStackTrace();;
          }
        } catch (MalformedURLException e) {
          e.printStackTrace();
        }
        break;
      
      case METHOD_POST:
        try {
          URL url = new URL(urlstr);
          HttpURLConnection huc = (HttpURLConnection) url.openConnection();
          huc.setDoOutput(true);
          huc.connect();

          OutputStream os = huc.getOutputStream();
          BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
          writer.write(param);
          writer.flush();
          writer.close();

          os.close();

          try (BufferedReader reader = new BufferedReader(new InputStreamReader(huc.getInputStream(), "UTF-8"))){
            StringBuffer resp = new StringBuffer();
            String inputLine;
            while((inputLine = reader.readLine()) != null){
              resp.append(inputLine);
            }
            reader.close();

            System.out.println(resp.toString());
          } catch (IOException e){
            e.printStackTrace();;
          }

        } catch (MalformedURLException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        }
    }
  }
}
