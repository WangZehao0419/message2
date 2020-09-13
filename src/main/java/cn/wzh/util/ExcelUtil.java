package cn.wzh.util;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ExcelUtil<T> {
    // 一个工作簿中有多个工作表。

    /**
     * 导出Excel表格（反射）
     * 反射就是程序可在其运行期间访问其内部任何属性。
     *
     * @param sheetName 工作表名称
     * @param fileName  文件名称
     * @param header    表头信息
     * @param response
     * @param data      数据集
     * @param pattern
     * @return
     */
    public String exportExcel(String sheetName, String fileName, String[] header, HttpServletResponse response, Collection<T> data, String pattern) throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook();
        OutputStream out = null;

        HSSFSheet sheet = workbook.createSheet(sheetName);
        createFirstRow(sheet, header);
        createOtherRow((List<T>) data, sheet, pattern);

        try {
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            out = response.getOutputStream();
            workbook.write(out);
        } finally {
            if (out != null) {
                out.close();
            }
            if (workbook != null) {
                workbook.close();
            }
        }
        return "";
    }

    /**
     * 创建表格标题行
     *
     * @param sheet
     * @param header
     */
    public void createFirstRow(Sheet sheet, String[] header) {
        // 创建该工作表的第一行
        Row row = sheet.createRow(0);
        // 循环给该工作表的第一行创建列，并给对应列赋对应的值。
        for (int i = 0; i < header.length; i++) {
            row.createCell(i).setCellValue(header[i]);
        }
    }

    /**
     * 创建表格数据行
     *
     * @param data
     * @param sheet
     */
    public void createOtherRow(List<T> data, Sheet sheet, String pattern) throws Exception {
        // for循环方式
        for (int i = 0; i < data.size(); i++) {
            // 第0行被标题行占据，所以数据行从第1行开始
            Row row = sheet.createRow(i + 1);

            T t = data.get(i);
            // 获取泛型的反射对象
            Class<?> clazz = t.getClass();

            // 通过反射对象获取所有的属性
            Field[] declaredFields = clazz.getDeclaredFields();
            for (int j = 0; j < declaredFields.length; j++) {
                Cell cell = row.createCell(j);
                // 获取单个属性
                String name = declaredFields[j].getName();
                // 拼接get方法的名称。get N ame   getName
                String methodName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
                // 根据get方法的名称及入参类型获取get方法
                Method method = clazz.getMethod(methodName, null);
                // 执行方法。第一个参数是调用该方法的对象，第二个参数是调用该方法时所传递的参数
                Object invoke = method.invoke(t, null);
                String value = "";
                if (invoke != null) {
                    // 检测数据类型，并做对应处理。
                    // 如果是日期类型，则对其进行日期格式化。
                    if (invoke instanceof Date) {
                        Date date = (Date) invoke;
                        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                        value = sdf.format(date);
                        // 如果没有检测出其类型，则将其当作字符串简单处理
                    } else {
                        value = invoke.toString();
                    }
                }
                // 给列赋值
                cell.setCellValue(value);

            }
        }

        // while循环方式
        /*Iterator<T> it = data.iterator();
        int index = 0;
        while (it.hasNext()) {
            index++;
            Row row = sheet.createRow(index);
            T t = it.next();

            // 此处省略，与for循环方式一致。
        }*/
    }

}
