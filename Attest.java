package edu.javaApi.sem6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Attest {
    public static void main(String[] args) {
        Set<Notebook> notebooksSet = new HashSet<>();
        fillNotebookSet(notebooksSet, 1000);
        searchNotebook(notebooksSet);
    }

    static void fillNotebookSet(Set<Notebook> nSet, int max) {
        for (int i = 0; i < max; i++) {
            nSet.add(new Notebook());
        }
    }

    private static void searchNotebook(Set<Notebook> inputSet) {
        Map<Integer, String> filterParam = new HashMap<>();
        filterParam.put(1, "mem");
        filterParam.put(2, "hdd");
        filterParam.put(3, "proc");
        filterParam.put(4, "vCard");
        filterParam.put(5, "vMem");
        filterParam.put(6, "os");
        filterParam.put(7, "color");
        Scanner sc = new Scanner(System.in);
        Map<String, String> searchParam = new HashMap<>();
        Set<Notebook> resSet = new HashSet<>();
        String choiseParam;
        int choise;
        while (true) {
            choiseParam = "";
            System.out.println(
                    "Выберите параметр поиска: \n1 - ОЗУ в Гб\n2 - Объем HDD в Гб\n3 - Процессор\n4 - Видеокарта\n5 - Объем видеопамяти в Мб\n6 - Операционная система\n7 - Цвет\n0 - Выход");
            choise = sc.nextInt();
            if (choise == 0) {
                sc.close();
                return;
            }
            choiseParam = inputParam(filterParam.get(choise), sc);
            if (choiseParam.length() > 0) {
                searchParam.put(filterParam.get(choise), choiseParam);
                resSet = searchByParam(inputSet, searchParam);
                printRes(resSet);
            }
            System.out.print("Закончить поиск? Для выхода введите 'y' или 'n' для продолжения: ");
            if ("y".equals(sc.next())) {
                sc.close();
                return;
            }
        }
    }

    private static void printRes(Set<Notebook> resSet) {
        for (Notebook notebook : resSet) {
            System.out.println(notebook);
        }
    }

    private static String inputParam(String choise, Scanner sc) {
        String choiseParam = "";
        switch (choise) {
            case "mem":
                System.out.print("Введите минимальное значение  в Гб: ");
                choiseParam = sc.next();
                break;
            case "hdd":
                System.out.print("Введите минимальное значение  в Гб: ");
                choiseParam = sc.next();
                break;
            case "proc":
                System.out.print("Введите производителя процессора(Intel,AMD): ");
                choiseParam = sc.next();
                break;
            case "vMem":
                System.out.print("Введите минимальное значение  в Мб: ");
                choiseParam = sc.next();
                break;
            case "vCard":
                System.out.print("Введите производителя видеокарты(NVidia, Ati): ");
                choiseParam = sc.next();
                break;
            case "os":
                System.out.print("Введите операционную систему(Windows, Linux): ");
                choiseParam = sc.next();
                break;
            case "color":
                System.out.print("Введите введите цвет ноутбука(Black, White, Grey): ");
                choiseParam = sc.next();
                break;
            default:
                System.out.println("Выберите верный параметр!");
        }
        return choiseParam;
    }

    private static Set<Notebook> searchByParam(Set<Notebook> inpuNotebooks,
            Map<String, String> searchParam) {
        Set<Notebook> resSet = new HashSet<>();
        boolean flag;
        for (Notebook notebook : inpuNotebooks) {
            flag = true;
            for (String k : searchParam.keySet()) {
                if ("mem".equals(k) || "hdd".equals(k) || "vMem".equals(k)) {
                    if (Integer.parseInt(notebook.getParam(k)) < Integer.parseInt(searchParam.get(k)))
                        flag = false;

                } else {
                    if (!notebook.getParam(k).equalsIgnoreCase(searchParam.get(k)))
                        flag = false;

                }
            }
            if (flag)
                resSet.add(notebook);
        }
        return resSet;
    }

}
