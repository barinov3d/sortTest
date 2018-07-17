import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] divisionsСodes = new String[]{"K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K1\\SK1", "K1\\SK2"};
        List<Departament> departaments = createsDepartaments(divisionsСodes);
        Collections.sort(departaments);
        print(departaments);
        System.out.println("-------------");
        Collections.reverse(departaments);
        print(departaments);
    }

    /**
     * Prints out all codes for all departaments in departaments collection
     *
     * @param departaments departament
     */
    private static void print(List<Departament> departaments) {
        for (Departament departament : departaments) {
            departament.printAllCodes();
        }
    }

    /**
     * Creates departaments objects with their codes from single array
     *
     * @param сodes codes
     * @return @class {@link Departament} objects with their own codes
     */
    private static List<Departament> createsDepartaments(String[] сodes) {
        List<Departament> departaments = new ArrayList<Departament>();
        if (сodes.length > 0) {
            String firstDepartamentId = сodes[0].replaceFirst("\\\\.*", "");
            departaments.add(new Departament(firstDepartamentId, сodes[0]));
            List<String> createdIds = new ArrayList<String>();
            createdIds.add(firstDepartamentId);
            for (int i = 1; i < сodes.length; i++) {
                String currentDepartamentId = сodes[i].replaceFirst("\\\\.*", "");
                if (createdIds.contains(currentDepartamentId)) {
                    for (Departament departament : departaments) {
                        if (departament.getDepartamentId().equals(currentDepartamentId)) {
                            departament.addCode(сodes[i]);
                            break;
                        }
                    }
                } else {
                    departaments.add(new Departament(currentDepartamentId, сodes[i]));
                    createdIds.add(currentDepartamentId);
                }
            }
        }
        /* sort codes inside departament object */
        for (Departament departament : departaments) {
            departament.sortCodes();
        }
        return departaments;
    }
}
