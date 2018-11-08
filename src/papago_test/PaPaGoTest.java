package papago_test;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class PaPaGoTest {

	private String clientId = "_4_gdAd1QTYBTvK2V1kJ";

	private String clientSecret = "3WFhGY9LgA";

	public void test() {
		HttpURLConnection huc = null;
		BufferedReader br = null;
		String text = "Hello";
		try {

			URL url = new URL("https://openapi.naver.com/v1/papago/n2mt");
			huc = (HttpURLConnection) url.openConnection();
			huc.setRequestMethod("POST");
			huc.setRequestProperty("X-Naver-Client-Id", clientId);
			huc.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			String param = "source=en&target=ko&text=" + text;
			huc.setDoOutput(true);
			DataOutputStream dos = new DataOutputStream(huc.getOutputStream());
			dos.writeBytes(param);
			dos.flush();
			dos.close();

			int status = huc.getResponseCode();

			if (status == 200) {

				br = new BufferedReader(new InputStreamReader(huc.getInputStream()));

			}

			String result;

			StringBuffer sb = new StringBuffer();

			while ((result = br.readLine()) != null) {

				sb.append(result);

			}

			br.close();

			if (status != 200) {

				System.out.println(sb.toString());

				throw new IOException(sb.toString());

			}
		} catch (MalformedURLException e) {
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

		/* fail("Not yet implemented"); */
}


