import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.Remote;

public interface IConventorService extends Remote
{
   public double  currencyConvertor(String from,String to,double amount) throws RemoteException,IOException;
   public double  celicusToFahrenheit(double celicus)throws RemoteException;
   public double  degreeToRadian(double degree)throws RemoteException;
 }
