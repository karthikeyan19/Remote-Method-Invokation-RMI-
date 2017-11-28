
import java.rmi.RemoteException;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.Naming;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.*;
public class ConventorService extends UnicastRemoteObject implements IConventorService {

    Map<String, Double> map = new HashMap<>();
    
    public  ConventorService()throws RemoteException{
     super();
     map.put("USDINR", 64.8);
     map.put("INRUSD",0.02);
     map.put("EURINR",77.7);
     map.put("INREUR",0.01);
     map.put("USDEUR",0.83);
     map.put("EURUSD",1.12);
    }
    public double  currencyConvertor(String from,String to,double amount) throws RemoteException,IOException{

       double currencyRate = map.get(from+to);
         
         
       return amount*currencyRate;

    }
   public double   celicusToFahrenheit(double celicus)throws RemoteException{
      return celicus*1.8+32;
   }
   public double  degreeToRadian(double degree)throws RemoteException{
      return degree*((22.0/7.0)/180.0);
   }
    
   public static void main(String args[])
    {
        try
        {
            ConventorService convertor = new ConventorService();
            Naming.rebind("rmi://localhost:5000/ConventorService1", convertor);
        }
        catch (Exception e)
        {
            System.out.println("ConvertorServer err: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


