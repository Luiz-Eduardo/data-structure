package homebanking;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Database {
    public static final ArrayList<Letra> caracteres;
    
    static{
        caracteres = new ArrayList<Letra>();
                
        String alpha = "abcdefghijklmnopqrstuvwxyz0123456789 ";
        
        
        for(int i = 0; i < alpha.length(); i++){
            caracteres.add(new Letra(alpha.substring(i, i+1)));
        }
    }
    
                
    public static Letra getLetra(String md5){
       for(int i = 0; i < caracteres.size(); i++){
           if(caracteres.get(i).getMd5Code().equals(md5))
            return caracteres.get(i);
       
       }
       
       return new Letra("-1"); //Tratamento de erros, caso não seja nenhum caractere alfanumérico.
    }
    
    public static Conta getConta(String[] keys){
       int tam = keys.length;
       Conta conta = new Conta("", "");
       
       String toCrypt = "";
       String nomeCliente = "", saldo = "";
       String expressao = "[-]?\\d*[.]?\\d+"; 
       //Expressão regular [-]? : com ou sem sinal de subtração.
       // \d* zero ou mais digitos.
       // [.]? com ou sem ponto.
       // \d+ um ou mais numeros.
       
       for(int i = 0; i < tam; i++)
           toCrypt += getLetra(keys[i]).getCaractere();
       
       for(int i = 0; i < toCrypt.length(); i++){
           if(Pattern.matches(expressao, toCrypt.substring(i, toCrypt.length()))){
               nomeCliente = toCrypt.substring(0, i-1); 
               saldo = toCrypt.substring(i, toCrypt.length());
               break;
           }
       }
       
       conta.setNomeCliente(nomeCliente);
       conta.setSaldo(saldo);
       
       return conta;    
    }
}
