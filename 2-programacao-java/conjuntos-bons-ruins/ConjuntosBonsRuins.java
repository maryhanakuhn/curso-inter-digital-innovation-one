import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SetGoodBad {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int palavra = Integer.valueOf(br.readLine());

        while (palavra != 0) {
            List<String> setC = new ArrayList<>();
            for (int i = 0; i < palavra; i++)
                setC.add(br.readLine());

            setC = setC.stream().sorted().collect(Collectors.toList());

            String saida = "Conjunto Bom";
            for (int i = 0; i < palavra - 1; i++) {
                if (setC.get(i + 1).startsWith(setC.get(i))) {
                    saida = "Conjunto Ruim";
                    break;
                }
            }

            System.out.println(saida);
            palavra = Integer.valueOf(br.readLine());
        }
    }
}