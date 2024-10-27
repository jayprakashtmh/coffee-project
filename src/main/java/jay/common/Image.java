package jay.common;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;

import jakarta.servlet.http.Part;

public class Image {
	public String saveImage(Part p, String folder) {
		String[] d = p.getContentType().split("/");
		String name = UUID.randomUUID().toString() + "." + d[1];
		String folder_path = "D:\\Java\\Advance Java\\Coffee\\src\\main\\webapp\\" + folder + "\\";
		String path = folder_path + name;

		try (FileOutputStream fos = new FileOutputStream(path); InputStream is = p.getInputStream()) {
			byte[] data = new byte[is.available()];
			is.read(data);
			fos.write(data);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return name;
	}
}
