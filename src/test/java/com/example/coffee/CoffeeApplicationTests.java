package com.example.coffee;

import com.example.coffee.dao.admins.AdAdminDao;
import com.example.coffee.model.dto.UserAdminVo;
import com.example.coffee.model.entity.AdAdmin;
import com.example.coffee.service.admins.ChUserInfoService;
import com.example.coffee.utils.AppriseMonthUtil;
import com.example.coffee.utils.PDFUtils;
import com.example.coffee.utils.PdfHtml;
import com.example.coffee.utils.PdfHtml2;
import com.example.coffee.utils.redis.RedisUtil;
import com.github.pagehelper.PageInfo;
import org.elasticsearch.common.recycler.Recycler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoffeeApplicationTests {

    @Resource
    private AdAdminDao adAdminDao;
    @Resource
    private ChUserInfoService chUserInfoService;
    int[] array={3,5,2,15,11,6,20,33,1,10};

    //    分组：10/2=5
//    {3,6},{5,20},{2,33},{15,1},{11,10}
//    对每一组排序
//    {3,6},{5,20},{2,33},{1,15},{10,11}
//    变成
//    {3,5,2,1,10,6,20,33,15,11};
//
//    再分一次：5/2=2
//    {3,2,10,20,15},{5,1,6,33,11}
//
//    {2,3,10,15,20},{1,5,6,11,33}
//    整体变成
//    {2,1,3,5,10,6,15,11,20,33}
//
//    再分一次：2/2=1
//    什么时候等于1，什么时候不再分了
//    直接最后一次插入排序
    public static int a(int b){

        int c=1;
        for(int i=1;i<b;i++){
            c=(c+1)*2;
        }
        return c;

    }
//冒泡排序
    public static void b(int a, int b,int c){
        int [] aa = new int[]{a,b,c};
        int temp;
        for(int i=0;i<aa.length;i++){
            for (int j=0;j<aa.length-1-i;j++){
                if (aa[j]>aa[j+1]){
                    temp=aa[j];
                    aa[j]=aa[j+1];
                    aa[j+1]=temp;
                }
            }
        }
        for (int i : aa) {
            System.out.println(i);
        }
    }

    //选择排序
    public static void selectSort(int a, int b,int c) {
        int[] arr = new int[]{a, b, c};

        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }

            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
            for (int k : arr) {
                System.out.println(k);
            }
        }
    }

    //插入排序
    public int[] insertSort() {

        int current;
        for (int i=0;i<array.length-1;i++){
            current=array[i+1];
            int preIndex=i;
            while (preIndex>=0 && current < array[preIndex]){
                array[preIndex + 1]=array[preIndex];
                preIndex--;
            }
            array[preIndex + 1]=current;
        }
        return array;
    }
    @Test
    public void c(){
        int a=a(20);
        System.out.println(a);
    }

    @Resource
    private RedisUtil redisUtil;
    @Test
    public void b(){


    }

    @Test
    public void contextLoads() {
        PageInfo<UserAdminVo> pageInfo = chUserInfoService.queryAllUserByVip(3,2,null);
        System.out.println(pageInfo);
        List<UserAdminVo> list = pageInfo.getList();
        for (UserAdminVo userAdminVo : list) {
            System.out.println(userAdminVo);
        }
    }

    @Test
    public void test(){
        List<String> list = PdfHtml2.PdfToImage("https://hdrs-ext-test.oss-cn-szfinance.aliyuncs.com/eshop/sit/file/PA042产品条款.pdf");
        for (String s : list) {
            System.out.println(s);
        }
        //PdfHtml.PdfToImage("E:\\KGBD2010\\CCAR-290-R2.pdf");
        //PDFUtils.pdf2multiImage("E:\\KGBD2010\\CCAR-290-R2.pdf","E:\\a.jpg");
//        List<String> list = PDFUtils.pdfToImagePath("E:\\KGBD2010\\CCAR-290-R2.pdf");
//        for (String s : list) {
//            System.out.println(s);
//        }
    }

    @Test
    public void test01(){
        File file = new File("E:\\Pdf2HTML");
        boolean delete = file.delete();
        System.out.println(delete);
    }

    @Test
    public void test02(){
        System.out.println(test03(6));
    }

    public static int test03(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        return test03(n-1) + test03(n-2);
    }

    @Test
    public void test05(){
        AdAdmin admin1 = new AdAdmin();
        admin1.setAid(1);
        admin1.setaName("aaa");
        AdAdmin admin2 = new AdAdmin();
        admin2.setAid(2);
        admin2.setaName("bbb");
        AdAdmin admin3 = new AdAdmin();
        admin3.setAid(3);
        admin3.setaName("ccc");
        AdAdmin admin4 = new AdAdmin();
        admin4.setAid(4);
        admin4.setaName("ddd");
        AdAdmin admin5 = new AdAdmin();
        admin5.setAid(5);
        admin5.setaName("eee");
        List<AdAdmin> list = new ArrayList<>();
        list.add(admin1);
        list.add(admin2);
        list.add(admin3);
        list.add(admin4);
        list.add(admin5);


        AdAdmin admin6 = new AdAdmin();
        admin6.setAid(2);
        admin6.setAvatar("bbbb");
        AdAdmin admin7 = new AdAdmin();
        admin7.setAid(3);
        admin7.setAvatar("cccc");
        AdAdmin admin8 = new AdAdmin();
        admin8.setAid(4);
        admin8.setAvatar("dddd");
        List<AdAdmin> list2 = new ArrayList<>();
        list2.add(admin6);
        list2.add(admin7);
        list2.add(admin8);
        for (AdAdmin admin : list) {
            if(list2!=null && list2.size()>0){
                for (AdAdmin adAdmin : list2) {
                    if(admin.getAid()==adAdmin.getAid()){
                        admin.setAvatar(adAdmin.getAvatar());
                        break;
                    }else{
                        admin.setAvatar("0");
                    }
                }

            }
        }
//        for (AdAdmin admin : list2) {
//            if(list!=null && list.size()>0){
//                for (AdAdmin adAdmin : list) {
//                    if(adAdmin.getAid()==admin.getAid()){
//                        adAdmin.setAvatar(admin.getAvatar());
//                    }else{
//                        adAdmin.setAvatar("0");
//                        continue;
//                    }
//                }
//            }
//
//        }
        for (AdAdmin admin : list) {
            System.out.println(admin.getAid()+"----"+admin.getAvatar());
        }
    }

    @Test
    public void test04(){
        double a1 = 125.123;
        BigDecimal b   =   new   BigDecimal(a1);
        double   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);
        DecimalFormat df   = new DecimalFormat("#0.000");

        double d1 = 3.23556;
        double d2 = 0;
        double d3 = 2.0;
        System.out.println("d1="+Double.parseDouble(df.format(d1)));
        System.out.println("d2="+df.format(d2));
        System.out.println("d3="+df.format(d3));
        Date date = new Date();
        long l = System.nanoTime();
        date.setTime(l);
        String s = AppriseMonthUtil.convertDateToString(date,AppriseMonthUtil.DATE_MS_PATTERN);
        System.out.println(s);
        long l1 = System.currentTimeMillis();
        date.setTime(l1);
        String s1 = AppriseMonthUtil.convertDateToString(date,AppriseMonthUtil.DATE_MS_PATTERN);
        System.out.println(s1);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.forEach(item -> {
            if (item == 2){
                item += 9;
            }
            System.out.println(item);
        });
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code",200);
        map.put("message","error");
        map.put("data","真实数据");
        map.forEach((key,value)->{
            System.out.println(
                    key+":"+value
            );
        });
    }
    @Test
    public void test10(){
        int i = (int) System.currentTimeMillis();
        System.out.println(i);
    }

    @Test
    public void big(){
        AdAdmin admin = new AdAdmin();
        List list = new ArrayList();
        admin.setaName("微服1");
        admin.setAid(1);
        list.add(admin);
        admin.setaName("微服2");
        admin.setAid(2);
        list.add(admin);
        admin.setaName("微服3");
        admin.setAid(3);
        list.add(admin);
        for (Object o : list) {
            System.out.println(o.toString());
        }

        List list2 = new ArrayList();
        String a =new String();
        for(int i=0; i<=3;i++){
            a = String.valueOf(i);
            list2.add(a);
        }
        for (Object o : list2) {
            System.out.println(o);
        }

    }

    @Test
    public void big2(){
        AdAdmin admin = new AdAdmin();
        List<AdAdmin> list = new ArrayList<AdAdmin>();
        admin.setaName("微服1");
        admin.setAid(1);
        list.add(admin);
        AdAdmin admin2 = new AdAdmin();
        admin2.setaName("微服2");
        admin2.setAid(2);
        list.add(admin2);
        AdAdmin admin3 = new AdAdmin();
        admin3.setaName("微服3");
        admin3.setAid(3);
        list.add(admin3);
        AdAdmin admin4 = new AdAdmin();
        admin4.setaName("微服4");
        admin4.setAid(4);
        list.add(admin4);
        Iterator<AdAdmin> iterator = list.iterator();
        while (iterator.hasNext()){
            AdAdmin next = iterator.next();
            if(next.getAid() == 1 || next.getAid() == 3){
                iterator.remove();
            }
        }

        for (AdAdmin o : list) {
            System.out.println(o);
        }


    }

    @Test
    public void getInetAddress() throws UnknownHostException {
        // 获取计算机名
        String name = InetAddress.getLocalHost().getHostName();
        // 获取IP地址
        String ip = InetAddress.getLocalHost().getHostAddress();
        System.out.println("计算机名："+name);
        System.out.println("IP地址："+ip);
    }

    @Test
    public void getInetAddresss() throws UnknownHostException {
        Integer nowMonthInt = AppriseMonthUtil.calculationMonth(new Date());
        System.out.println(nowMonthInt);

        Integer integer = AppriseMonthUtil.calculationMonth("2021-03");
        System.out.println(integer);
    }

    @Test
    public void getSplit(){
        String pdfPath = "/u01/app/upload/2021/05/25/20212825032800/pdf_pagenum/先生的星无忧（星动版）重大疾病保险建议书.pdf";
        String[] datePdf = pdfPath.split("/");
        for (String s : datePdf) {
            System.out.print(s+"        ");
        }
        String[] pdfName = datePdf[9].split(".pdf");
        for (String s : pdfName) {
            System.out.println();
            System.out.print(s+"        ");
        }
        String url = "https://uwcsp.pflife.com.cn/pdf/" + datePdf[4]+ "@" + datePdf[5] + "@"+ datePdf[6] + "@"+ datePdf[7]+ "@" + datePdf[8] + "@" + pdfName[0]+".do";
        System.out.println(url);
    }

    @Test
    public void getSplit1(){
        String valueFormat = (new BigDecimal("-.1")).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP).negate().toString()+"%";
        System.out.println(valueFormat);
    }

    @Test
    public void g1(){
        int i1 = 128;
        Integer i2 = 128;
        Integer i3 = new Integer(128);
        System.out.println(i1==i2);
        System.out.println(i1==i3);
        Integer i4=127;
        Integer i5=127;
        Integer i6=128;
        Integer i7=128;
        System.out.println(i4==i5);
        System.out.println(i6==i7);

        Integer i8 = new Integer(127);
        Integer i9 = new Integer(127);

        System.out.println(i8==i9);
        System.out.println(i8.equals(i9));
        System.out.println(i4==i8);
    }

   @Test
    public void g2(){
//        List<String> list1 = new ArrayList<>();
//        list1.add("1");
//        list1.add("2");
//        list1.add("3");
//       for (String string : list1) {
//           if("1".equals(string)){
//               list1.remove(string);
//           }
//       }
//       System.out.println(list1.toString());

//       List<String> list2 = new ArrayList<>();
//       list2.add("1");
//       list2.add("2");
//       list2.add("3");
//       Iterator it = list2.iterator();
//       while (it.hasNext()){
//           String str = (String)it.next();
//           if("2".equals(str)){
//               list2.remove(str);
//           }
//       }
//       System.out.println(list2);

       List<String> alist = new ArrayList<>();
       alist.add("1");
       alist.add("2");
       alist.add("3");
       Iterator it1 = alist.iterator();
       while (it1.hasNext()){

           if("3".equals(it1.next())){
               it1.remove();
           }
       }
       System.out.println(alist.toString());
    }
    
    @Test
    public void g3(){
        Calendar terminalDate = new GregorianCalendar();
        Calendar terminalDate2 = new GregorianCalendar();
        terminalDate.setTime(new Date());
        terminalDate.add(Calendar.MONTH,3);
        terminalDate.set(Calendar.DAY_OF_MONTH,terminalDate.get(Calendar.DAY_OF_MONTH)-1);
        terminalDate2.setTime(new Date());
        terminalDate2.set(Calendar.DAY_OF_MONTH,terminalDate2.get(Calendar.DAY_OF_MONTH)-1);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(terminalDate.getTime()));
        System.out.println(format.format(terminalDate2.getTime()));
    }


}
