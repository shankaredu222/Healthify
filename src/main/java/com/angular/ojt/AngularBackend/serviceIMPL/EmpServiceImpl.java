package com.angular.ojt.AngularBackend.serviceIMPL;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.angular.ojt.AngularBackend.dao.EmpDao;
import com.angular.ojt.AngularBackend.entity.Country;
import com.angular.ojt.AngularBackend.entity.Employee;
import com.angular.ojt.AngularBackend.service.EmpService;
import com.mysql.fabric.xmlrpc.base.Data;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDao dao;

//	@Override
//	public String addemp(Employee employee) {
//		String id = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());
//		employee.setId(Long.parseLong(id));            //employee.setId(Long.parseLong(id));
//		return dao.addemp(employee);
//	}

	@Override
	public String updateEmp(Employee e) {
		System.out.println(e);
		return dao.updateEmp(e);
	}

	@Override
	public String deleteEmpById(Long id) {
		return dao.deleteEmpById(id);
	}

	@Override
	public String deleteEmpByName(String name) {

		return dao.deleteEmpByName(name);
	}

	@Override
	public List<Employee> getAllEmp() {

		return dao.getAllEmp();
	}

	@Override
	public Employee getEmpById(Long id) {

		return dao.getEmpById(id);
	}

	@Override
	public Boolean addemp(@Valid Employee e) {
		String id = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());
		e.setId(Long.parseLong(id));
		return dao.addemp(e);
	}

	private List<Employee> readExcelFile(String filePath) {

		List<Employee>list = new ArrayList<>();
		try {
			Workbook workbook = new XSSFWorkbook(filePath);

			Sheet sheet = workbook.getSheetAt(0);
			
			Iterator<Row> rows = sheet.rowIterator();

			while (rows.hasNext()) {
				Row row = (Row) rows.next();
				if (row.getRowNum() == 0) {
					continue;
				}
				Employee employee = new Employee();
				String id = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());
				employee.setId(Long.parseLong(id));
				
				Iterator<Cell> cells = row.cellIterator();
				while (cells.hasNext()) {
					Cell cell = (Cell) cells.next();
//					CellType cellType = cell.getCellType();
//					if(cellType==CellType.STRING) {
//						System.out.print(cell.getStringCellValue()+"\t");
//					}else{
//						System.out.print(cell.getNumericCellValue()+"\t");
//					}

					int columnIndex = cell.getColumnIndex();
					System.out.println(columnIndex);

					switch (columnIndex) {
					case 0: {
						System.out.println(cell.getStringCellValue());
						employee.setFirstName(cell.getStringCellValue());
						break;
					}

					case 1: {
						System.out.println(cell.getStringCellValue());
						employee.setLastName(cell.getStringCellValue());
						break;
					}
					
					case 2: {
						System.out.println(cell.getStringCellValue());
						employee.setUsername(cell.getStringCellValue());
						break;
					}
					
					case 3: {
						System.out.println(cell.getStringCellValue());
						employee.setPassword(cell.getStringCellValue());
						break;
					}
					case 4: {
						System.out.println(cell.getNumericCellValue());
						employee.setMobPhone((long) cell.getNumericCellValue());
						break;
					}
					case 5: {
						System.out.println(cell.getStringCellValue());
						employee.setEmail(cell.getStringCellValue());
						break;
					}
					case 6: {
						System.out.println(cell.getStringCellValue());
						employee.setGender(cell.getStringCellValue());
						break;
					}
					
					case 7: {
						System.out.println(cell.getStringCellValue());
						employee.setAddress(cell.getStringCellValue());
						break;
					}
					
					case 8: {
						System.out.println(cell.getDateCellValue());
						employee.setCreationDate(cell.getDateCellValue());
						break;
					}
					
					case 9: {
						System.out.println(cell.getStringCellValue());
						employee.setCreatedBy(cell.getStringCellValue());
						break;
					}
					case 10: {
						System.out.println(cell.getDateCellValue());
						employee.setUpdateDate(cell.getDateCellValue());
						break;
					}
					case 11: {
						System.out.println(cell.getStringCellValue());
						employee.setUpdatedBy(cell.getStringCellValue());
						break;
					}
					
					case 12: {
						System.out.println(cell.getStringCellValue());
						employee.setStatus(cell.getStringCellValue());
						break;
					}
					case 13: {
						System.out.println(cell.getNumericCellValue());
						Country country = new Country();
						country.setCountryID((long) cell.getNumericCellValue());
						employee.setCountryID(country);
						break;
					}
					
					}

					
				}
				list.add(employee);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	@Override
	public String uploadFile(MultipartFile file) {
		String path = "src/main/resources";
		String name = file.getOriginalFilename();
		String msg=null;
		try {
			FileOutputStream fos = new FileOutputStream(path + File.separator + name);
			byte[] data = file.getBytes();
			fos.write(data);

			List<Employee> readExcelFile = this.readExcelFile(path + File.separator + name);
			
			for (Employee employee : readExcelFile) {
				System.out.println(employee);
			}
			
			msg=dao.uploadSheet(readExcelFile);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return msg;
	}

}
