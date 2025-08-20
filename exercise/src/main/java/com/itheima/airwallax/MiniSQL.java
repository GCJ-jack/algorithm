package com.itheima.airwallax;

import java.util.*;
import java.util.stream.Collectors;

public class MiniSQL {
    static Map<String, ArrayList<String>> map = new HashMap<>();
    static final List<String> COLS = List.of("country", "latitude", "longitude", "country_name");

    // 1) 数据来源：这里硬编码两行。你也可以把 data 换成读文件的内容。
    public static void from() {
        ensureCols();

        String data = """
            AD,42.546245,1.601554,Andorra
            AE,23.424076,53.847818,United Arab Emirates
        """;

        for (String line : data.strip().split("\\R")) {
            if (line.isBlank()) continue;
            String[] parts = line.split(",", 4); // 恰好 4 列
            if (parts.length != 4) {
                throw new IllegalArgumentException("Bad row: " + line);
            }
            map.get("country").add(parts[0].trim());
            map.get("latitude").add(parts[1].trim());
            map.get("longitude").add(parts[2].trim());
            map.get("country_name").add(parts[3].trim());
        }
    }

    // 2) SELECT col1,col2,...  -> 返回 CSV 字符串（含表头）
    public static String select(String columns) {
        ensureCols();
        List<String> cols = Arrays.stream(columns.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
        if (cols.isEmpty()) throw new IllegalArgumentException("No columns provided");
        for (String c : cols) {
            if (!map.containsKey(c)) {
                throw new IllegalArgumentException("Unknown column: " + c);
            }
        }

        int rows = count();
        StringBuilder sb = new StringBuilder();
        // header
        sb.append(String.join(",", cols)).append("\n");
        // rows
        for (int i = 0; i < rows; i++) {
            List<String> row = new ArrayList<>(cols.size());
            for (String c : cols) row.add(map.get(c).get(i));
            sb.append(String.join(",", row)).append("\n");
        }
        return sb.toString();
    }

    // 3) JOIN：把指定列的前 n 个值用逗号拼起来（像 GROUP_CONCAT 的简单版）
    public static String join(String column, int n) {
        ensureCols();
        if (!map.containsKey(column)) {
            throw new IllegalArgumentException("Unknown column: " + column);
        }
        List<String> col = map.get(column);
        n = Math.max(0, Math.min(n, col.size()));
        return String.join(",", col.subList(0, n));
    }

    // 4) TAKE：取前 5 行（可根据需要改），输出全部列的 CSV（含表头，按固定列序）
    public static String take() {
        ensureCols();
        int limit = Math.min(5, count());
        StringBuilder sb = new StringBuilder();
        sb.append(String.join(",", COLS)).append("\n");
        for (int i = 0; i < limit; i++) {
            List<String> row = new ArrayList<>(COLS.size());
            for (String c : COLS) row.add(map.get(c).get(i));
            sb.append(String.join(",", row)).append("\n");
        }
        return sb.toString();
    }

    // 5) COUNT：行数（任取一列长度即可）
    public static int count() {
        ensureCols();
        return map.get("country").size();
    }

    // 6) SORT：按 country_name 升序排序（可改：传参或改默认列）
    public static void sort() {
        ensureCols();
        String sortBy = "country_name";
        List<String> keyCol = map.get(sortBy);
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < keyCol.size(); i++) order.add(i);

        order.sort(Comparator.comparing(keyCol::get, Comparator.nullsFirst(String::compareTo)));

        // 让所有列按相同的行顺序重排
        for (String c : COLS) {
            List<String> oldList = map.get(c);
            ArrayList<String> newList = new ArrayList<>(oldList.size());
            for (int idx : order) newList.add(oldList.get(idx));
            map.put(c, newList);
        }
    }

    // 工具：确保列存在
    private static void ensureCols() {
        for (String c : COLS) map.putIfAbsent(c, new ArrayList<>());
        // 校验列长度一致性（避免脏数据）
        int expected = map.get("country").size();
        for (String c : COLS) {
            if (map.get(c).size() != expected) {
                throw new IllegalStateException("Column length mismatch at " + c);
            }
        }
    }

    public static void main(String[] args) {
        // 初始化列
        for (String c : COLS) map.put(c, new ArrayList<>());

        // 导入数据
        from();

        System.out.println("=== COUNT ===");
        System.out.println(count()); // 2

        System.out.println("=== TAKE (first 5 rows or fewer) ===");
        System.out.print(take());

        System.out.println("=== SELECT country,country_name ===");
        System.out.print(select("country,country_name"));

        System.out.println("=== JOIN country (n=2) ===");
        System.out.println(join("country", 2));

        System.out.println("=== SORT by country_name then SELECT ALL ===");
        sort();
        System.out.print(select(String.join(",", COLS)));
    }
}
