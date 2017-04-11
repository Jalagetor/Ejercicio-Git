package paquete;

import java.util.*;
import java.io.*;

public class socio implements Serializable
{
	File f = null;
	Scanner sc = null;
	FileOutputStream fos = null;
	ObjectOutputStream oos = null;
	FileInputStream fis = null;
	ObjectInputStream ois = null;

	public static void escribe(){

		try{
			File f = new File("socios.txt");
			Scanner sc = new Scanner(f);
			FileOutputStream fos = new FileOutputStream("socios.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			while(sc.hasNext())
			{
				String linea=sc.nextLine();
				StringTokenizer st = new StringTokenizer(linea);

				String nombre=st.nextToken();
				String apellido1=st.nextToken();
				String apellido2=st.nextToken();
				String dni=st.nextToken();
				String nacimiento=st.nextToken();

				socio s = new socio(nombre,apellido1,apellido2,dni,nacimiento);

				oos.writeObject(s);
			}
			if (oos!=null)
			{
				oos.close();
				fos.close();
			}
			if (sc!=null)
			{	
				sc.close();
			}
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
	}

	public static void lee(){

		try
		{

		FileInputStream fis = new FileInputStream("socios.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);

			try
			{
				while (true)
				{
					socio s = (socio)ois.readObject();
					System.out.println(s.toString());
				}
			}
			catch (EOFException e)
			{
				System.out.println("Fin de fichero");
			}

			if (ois != null)
			{	
				ois.close();
				fis.close();
				System.exit(0);
			}
		}
		catch (ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}

	}
}