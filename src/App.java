public class App {
    public static void main(String[] args) throws Exception {
        MyHashMap<String, String> hMap = new MyHashMap<>();
        hMap.put("Gabriel", "o Gamer");
        hMap.put("Misao", "o Gordo");
        hMap.put("Alex", "o Drogado");
        hMap.put("Garcia", "o Casado");
        hMap.put("Manuw", "o Formado");
        System.out.println(hMap);

        hMap.put("Gabriel", "o Milhonario");
        System.out.println(hMap.get("Manuw"));
        System.out.println(hMap.remove("Alex"));

    }

}
