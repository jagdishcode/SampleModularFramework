package com.timepass;

import java.io.File;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class JavaReceiptOcr {
	public static void main(String[] args) throws Exception {
		String receiptOcrEndpoint = "https://ocr.asprise.com/api/v1/receipt"; // Receipt OCR API endpoint
		File imageFile = new File("C:\\Users\\206433293\\Downloads\\costco.jpeg");

		System.out.println("=== Java Receipt OCR ===");

		try (CloseableHttpClient client = HttpClients.createDefault()) {
			HttpPost post = new HttpPost(receiptOcrEndpoint);
			post.setEntity(MultipartEntityBuilder.create().addTextBody("api_key", "TEST") // Use 'TEST' for testing
																							// purpose
					.addTextBody("recognizer", "auto") // can be 'US', 'CA', 'JP', 'SG' or 'auto'
					.addTextBody("ref_no", "ocr_java_123'") // optional caller provided ref code
					.addPart("file", new FileBody(imageFile)) // the image file
					.build());

			try (CloseableHttpResponse response = client.execute(post)) {
				System.out.println(EntityUtils.toString(response.getEntity())); // Receipt OCR result in JSON
			}
		}
	}
}