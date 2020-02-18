package controller;

import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;


import model.product.ProductBean;
import model.product.ProductBeanService;


//1)寫入、讀取 產品資料
//2)未完成
//3)Aming

@Controller
@SessionAttributes(names = {"name", "price","stock","description","image","timestamp","category", "errors"})
public class ProductController {
	
	@Autowired
	private HttpServletRequest request;
	private ProductBeanService prservice;
	
	public ProductController(ProductBeanService prService) {
		this.prservice = prService;
	}
	
	@RequestMapping(path="/productbean.controller", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<byte[]> uploadFile(@RequestParam(name = "image") MultipartFile multipartfile)
			throws Exception {
		String fileName = multipartfile.getOriginalFilename();
		System.out.println("fileName=" + fileName);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);

		String savePath = request.getSession().getServletContext().getRealPath("/") + "uploadTempDir\\" + fileName;
		System.out.println("savePath=" + savePath);

		File saveFile = new File(savePath);
		multipartfile.transferTo(saveFile);

		if (fileName != null && fileName.length() != 0) {
			savePicture(fileName, savePath);
		}

		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(saveFile), headers, HttpStatus.OK);
		
	}

	private void savePicture(String fileName, String savePath) {
		try {
			ProductBean ProductBean = new ProductBean();

			FileInputStream is1 = new FileInputStream(savePath);
			byte[] data = new byte[is1.available()];
			is1.read(data);
			is1.close();
			
			ProductBean.setProductImg(data);
			prservice.saveProduct(ProductBean);		
			System.out.println("File ["+fileName+"] at root ["+savePath+"] has successfully SAVED");
		} catch (Exception e) {
			System.out.println("ERROR: File failed to save!");
            e.printStackTrace();
		}
	}
	
	
	public String processAction(@RequestParam(name = "name") String name, 
			                    @RequestParam(name = "price") float price,
			                    @RequestParam(name = "stock") int stock,
			                    @RequestParam(name = "description") String description,
			                    @RequestParam(name = "timestamp") Date timestamp,
			                    @RequestParam(name = "category") String category,
			                   
			                    Model pr) throws ParseException {
	
		
		Map<String, String> errors = new HashMap<String, String>();
		pr.addAttribute("errors",errors);
		
		if (name == null || name.length() == 0) {
			errors.put("name", "name is required");
		}	
		String s =String.valueOf(price);
		if (s == null|| s.length() == 0 ) {
			errors.put("price", "price is required");
		}
		String st =String.valueOf(stock);
		if ( st == null || st.length() == 0) {
			errors.put("stock", "stock is required");
		}
		
		if (description == null || description.length() == 0) {
			errors.put("description", "description is required");
		}
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
		String ti =sdf.format(timestamp);
		Date date = sdf.parse(ti);
		if (ti == null || ti.length() == 0) {
			errors.put("timestamp", "timestamp is required");
		}
		
		if (category == null || category.length() == 0) {
			errors.put("category", "category is required");
		}
		
		if (errors!=null && !errors.isEmpty()) {
			return "productbean";
		}
		
		
			
		pr.addAttribute("name", name);
		pr.addAttribute("price", price);
		pr.addAttribute("stock", stock);
		pr.addAttribute("description", description);
		pr.addAttribute("timestamp", date);
		pr.addAttribute("category", category);
		
			return "product";
		}		
		
	
	
		
}
	
	

	

