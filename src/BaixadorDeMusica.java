import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.util.Scanner;
public class BaixadorDeMusica {

    public void spotfy_format(){
        try{
            Scanner ler = new Scanner(System.in);
            String link;
            System.out.println("Qual o link da música?");
            link = ler.nextLine();

            ProcessBuilder builder = new ProcessBuilder(
                    "yt-dlp",
                    "-x",
                    "--audio-format", "m4a",
                    "--add-metadata",
                    "--embed-thumbnail",
                    "--no-playlist",
                    "-o", "%(title)s.%(ext)s",
                    link
            );

            String homeUsuario = System.getProperty("user.home");
            builder.directory(new File(homeUsuario + "/Downloads"));

            builder.redirectErrorStream(true);

            Process processo = builder.start();

            BufferedReader leitor = new BufferedReader(new InputStreamReader(processo.getInputStream()));
            String linha;
            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
            }
            int codigoSaida = processo.waitFor();
            System.out.println("\nProcesso finalizado com código: " + codigoSaida);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void video_instagram(){
        //yt-dlp -U (COMANDO PARA ATUALIZAR O YT)
        try{
            Scanner ler = new Scanner(System.in);
            String link;
            System.out.println("Qual o link do vídeo?");
            link = ler.nextLine();

            ProcessBuilder builder = new ProcessBuilder(
                    "yt-dlp",
                    "-f", "b", //
                    "-o", "%(uploader)s - %(title)s.%(ext)s",
                    link
            );

            String homeUsuario = System.getProperty("user.home");
            builder.directory(new File(homeUsuario + "/Downloads"));

            builder.redirectErrorStream(true);

            Process processo = builder.start();

            BufferedReader leitor = new BufferedReader(new InputStreamReader(processo.getInputStream()));
            String linha;
            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
            }
            int codigoSaida = processo.waitFor();
            System.out.println("\nProcesso finalizado com código: " + codigoSaida);

        }catch(Exception e){
            e.printStackTrace();
        }


    }





}
