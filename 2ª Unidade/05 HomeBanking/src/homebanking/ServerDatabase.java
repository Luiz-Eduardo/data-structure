package homebanking;

import java.math.BigInteger;
import java.util.ArrayList;

public class ServerDatabase {
    public static final ArrayList<ArrayList<Conta>> contas;
    public static final int N = 100;
    
    static{
        contas = new ArrayList<ArrayList<Conta>>();
        for(int i = 0; i < N; i++){
            contas.add(new ArrayList<Conta>());
        }
    }
    
    public static int hashCode(String md5){
        BigInteger bi = new BigInteger(md5, 16);
        BigInteger m = new BigInteger(Integer.toString(N), 10);
        
        int pos;
        pos = bi.mod(m).intValue();
    
        return pos;
    }
    
    public static void insereConta(Conta conta){
        String hash = SecurityProvider.md5ToServer(conta);
        int pos = hashCode(hash);
        
        contas.get(pos).add(conta);
    }
    
    public static Conta getConta(String md5){
        int pos = hashCode(md5);
        
        for(Conta conta : contas.get(pos)){
            if(conta.getMd5().compareTo(md5) == 0) 
                return conta;
        }
        
        return null;
    }
}
