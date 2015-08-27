package telas;

import java.io.*;
import javax.swing.JOptionPane;

public class CryptoDummy{
   private byte[] textoCifrado;
   private byte[] textoDecifrado;
   public CryptoDummy()
   {
      textoCifrado = null;
      textoDecifrado = null;
   }
   public void geraChave(File fDummy) throws IOException
   {
   // Gera uma chave Dummy simetrica (dk: 0 a 100):
      int dk = (int) (Math.random()*55744) + 101;
     JOptionPane.showMessageDialog(null,dk);
   // Grava a chave Dummy simetrica em formato serializado
      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fDummy));
      oos.writeObject(dk);
      oos.close();
   }
   public void geraCifra(byte[] texto, File fDummy)
   throws IOException, ClassNotFoundException
   {
      ObjectInputStream ois = new ObjectInputStream (new FileInputStream (fDummy));
      int iDummy = (Integer) ois.readObject();
      ois.close();
      textoCifrado = texto;
      for(int i = 0; i < texto.length; i++)
      {
         textoCifrado[i] = (byte) (textoCifrado[i] + iDummy );
      }
   }
   public byte[] getTextoCifrado() throws Exception
   {
      return textoCifrado;
   }
   public void geraDecifra(byte[] texto, File fDummy)
   throws IOException, ClassNotFoundException
   {
      ObjectInputStream ois = new ObjectInputStream (new FileInputStream (fDummy));
      int iDummy = (Integer) ois.readObject();
      ois.close();
      textoDecifrado = texto;
      for(int i = 0; i < texto.length; i++)
      {
         textoDecifrado[i] = (byte) (textoDecifrado[i] - iDummy);
      }
   }
   public byte[] getTextoDecifrado() throws Exception
   {
      return textoDecifrado;
   }
}
