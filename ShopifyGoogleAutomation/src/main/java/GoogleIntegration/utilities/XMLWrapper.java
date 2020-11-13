package GoogleIntegration.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XMLWrapper {

	File xml = new File(System.getProperty("user.dir") + "/src/main/resources/ObjectRepository.xml");
	XmlMapper xmlMapper = new XmlMapper();

	public static void main(String[] args) {
		XMLWrapper wrapper = new XMLWrapper();
		wrapper.readXML();
	}

	private void readXML() {
		try {
			FileInputStream is = new FileInputStream(xml);
			JacksonXmlModule jacksonXmlModule = new JacksonXmlModule();
			jacksonXmlModule.setDefaultUseWrapper(false);
			byte[] data = Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/src/main/resources/ObjectRepository.xml"));
			Application map = xmlMapper.readValue(data, Application.class);
			System.out.println("Reading of map Started...");
			System.out.println("Json  :: " + new ObjectMapper().convertValue(map, JsonNode.class));
			System.out.println("Reading of map Ended...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static class Application {
		private String value;

		@JsonProperty("Page")
		private List<Page> page;

		@Override
		public String toString() {
			return "XMLJSON [value = " + value + ", page = " + page + "]";
		}

		public List<Page> getPage() {
			return page;
		}

		public void setPage(List<Page> page) {
			this.page = page;
		}


		public String getValue() { return value; }

		public void setValue(String value) { this.value = value; }

		public static class Page {
			private String name;
			@JsonProperty("Element")
			private Element element;


			public Element getElement() {
				return element;
			}

			public void setElement(Element element) {
				this.element = element;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			@Override
			public String toString() {
				return "Page [name=" + name + ", element=" + element + "]";
			}

			public static class Element {
				private String name;
				private String type;
				private String locator;
				private String selector;

				public String getName() {
					return name;
				}

				public void setName(String name) {
					this.name = name;
				}

				public String getType() {
					return type;
				}

				public void setType(String type) {
					this.type = type;
				}

				public String getLocator() {
					return locator;
				}

				public void setLocator(String locator) {
					this.locator = locator;
				}

				public String getSelector() {
					return selector;
				}

				public void setSelector(String selector) {
					this.selector = selector;
				}

				@Override
				public String toString() {
					return "Element [name=" + name + ", type=" + type + ", locator=" + locator + ", selector="
							+ selector + "]";
				}

			}
		}
	}

}
