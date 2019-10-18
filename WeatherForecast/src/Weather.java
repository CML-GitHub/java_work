import java.io.*;
import java.net.*;
import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import java.net.MalformedURLException;


/**
 * @author ML C
 */
public class Weather{
    
    /**
     * 获取城市代码
     **/
    public int GetCityID(String CityName)throws JSONException{
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("F:\\java代码\\WeatherForecast\\weather_city.json"));
            String string = null;
            String data = "";
            while ((string = bufferedReader.readLine()) != null) {
                data += string;
            }
    
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("城市代码");      //找到城市代码的json数组
            int i = 0;
            
            for (; i < jsonArray.length(); i++) {
                JSONObject info = jsonArray.getJSONObject(i);
                JSONArray jsonArray1 = info.getJSONArray("市");
                for(int j = 0;j < jsonArray1.length();j++) {
                    JSONObject info1 = jsonArray1.getJSONObject(j);
                    String name = info1.getString("市名");
                    if (name.equals(CityName)) {
                        return info1.getInt("编码");
                    }
                }
            }
            if ( i == jsonArray.length())
                System.out.println("输入城市有误(天气预报最低精确到市)");
        }catch (IOException e){
            System.out.println("文件读取失败");
        }
        return 0;
    }
    
    /**
     *
     * @param json  json转xml
     * @return  xml
     * @throws JSONException
     */
    
    public String JsonToXml(String json)throws JSONException{
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<?xml version = \"1.0\" encoding = \"utf-8\"?>");
        JSONObject jsonObject = new JSONObject(json);
        String xml = XML.toString(jsonObject);
        return xml;
    }
    
    /**
     * 读取xml字符串 输出天气信息
     * @param XmlString
     * @param Label
     * @return
     */
    
    public String ReadXML(String XmlString,String Label){
        String StartLabel = "<" + Label + ">";
        String EndLabel = "</" + Label + ">";
        if(null == XmlString){
            return null;
        }
        int iFirst = XmlString.indexOf(StartLabel);
        int iLast = XmlString.indexOf(EndLabel);
        if(iFirst < 0|| iLast < 0)
            return null;
        int BeginIndex = iFirst + StartLabel.length();
        return XmlString.substring(BeginIndex,iLast);
    }
    
    
    public void PrintWeather(String XMLText,String Date, String City,String Tem2 ,String Tem1,String Tem ,String Week,String UpdateTime,String Wea,String Win,String Win_Speed){
        System.out.println(ReadXML(XMLText,Date) + "   "+ReadXML(XMLText,Week));
        System.out.println(ReadXML(XMLText,City));
        System.out.println("最低温度：" + ReadXML(XMLText,Tem2) +"  " + "最高温度：" + ReadXML(XMLText,Tem1) + "  全天平均温度：" + ReadXML(XMLText,Tem));
        System.out.println(ReadXML(XMLText,Wea) + "     " + ReadXML(XMLText,Win) +"  "+ReadXML(XMLText,Win_Speed));
        System.out.println("最后更新时间" + ReadXML(XMLText,UpdateTime));
    }
    
    /**
     *
     * @param CityID 城市代码
     * @throws MalformedURLException
     * @throws IOException
     */
    public void GetWeatherJSON(int CityID) throws  IOException ,JSONException {
        URL url = new URL("https://www.tianqiapi.com/api/?version=v6&cityid=" + CityID + "&appid=Cml&appsecret=@Caomenglong");
        
        URLConnection urlConnection = url.openConnection();
        urlConnection.setConnectTimeout(1000);              //设置超时方法
        try {
            //从www.tianqiapi.com网站获取数据以json格式
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null)      //将网站数据读取到line
                stringBuilder.append(line);
            String datas = JsonToXml(stringBuilder.toString());     //将json转换为xml
            //System.out.println(datas);
            PrintWeather(datas,"date","city","tem2" ,"tem1","tem","week","update_time","wea","win","win_speed");
            
        } catch (SocketException e){
            System.out.println("连接超时");
        }
        
        
        
        
    }
    
    public static void main(String[] args)throws IOException,JSONException{
        Weather weather  = new Weather();
        int ID = weather.GetCityID("荆州");
        weather.GetWeatherJSON(ID);
    }
}
