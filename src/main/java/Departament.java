import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Departament implements Comparable<Departament> {
    private List<String> codes = new ArrayList<String>();
    private String departamentId;

    public Departament(String departamentId, String code) {
        this.departamentId = departamentId;
        addCode(code);
    }

    public List<String> getCodesList() {
        return codes;
    }

    public String getDepartamentId() {
        return departamentId;
    }

    public void addCode(String code) {
        codes.add(code);
    }

    public void printAllCodes() {
        for (String code : codes) {
            System.out.println(code);
        }
    }

    public void sortCodes() {
        Collections.sort(codes);
    }

    public int compareTo(Departament departament) {
        return departamentId.compareTo(departament.getDepartamentId());
    }
}
