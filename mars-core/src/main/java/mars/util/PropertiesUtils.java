package mars.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Ricky Fung
 */
public class PropertiesUtils {

	public static Properties load(File file) throws IOException {
		Asserts.notNull(file);
		InputStream in = null;
		try {
			in = new FileInputStream(file);
			Properties props = new Properties();
			props.load(in);
			return props;
		}finally{
			StreamUtils.closeQuietly(in);
		}
	}

	/**
	 * com/mindflow/config.properties
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static Properties load(String path) throws IOException {
		Asserts.notNull(path);
		InputStream in = null;
		try {
			in = ClassUtils.getDefaultClassLoader().getResourceAsStream(path);
			Properties props = new Properties();
			props.load(in);
			return props;
		}finally{
			StreamUtils.closeQuietly(in);
		}
	}

}
