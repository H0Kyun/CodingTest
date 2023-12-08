import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

public class Main {
    private int N;
    private int L;
    private int R;
    private int[][] countryPopulation;

    public static void main(String[] args) {
        Main solution = new Main();
        solution.init();
        System.out.println(solution.getDaysOfMovement());
    }

    private int getDaysOfMovement() {
        int daysOfMovement = 0;
        while (true) {
            List<Union> unionList = checkBorder();
            if (unionList.isEmpty()) {
                break;
            }

            movePopulation(unionList);
            ++daysOfMovement;
        }

        return daysOfMovement;
    }

    private void movePopulation(List<Union> unionList) {
        unionList.forEach(union -> {
            int populationAverage = union.getPopulationAverage();
            union.getCountryCoordinates().forEach(ints -> {
                countryPopulation[ints[0]][ints[1]] = populationAverage;
            });
        });
    }

    private List<Union> checkBorder() {
        List<Union> unionList = new ArrayList<>();
        boolean[][] isVisited = new boolean[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (isVisited[i][j]) {
                    continue;
                }

                createUnion(isVisited, i, j).ifPresent(unionList::add);
            }
        }
        return unionList;
    }

    private Optional<Union> createUnion(boolean[][] isVisited, int i, int j) {
        Union union = new Union();
        searchCountry(isVisited, i, j, union);
        return union.isValidUnion() ? Optional.of(union) : Optional.empty();
    }

    private void searchCountry(boolean[][] isVisited, int y, int x, Union union) {
        isVisited[y][x] = true;
        union.addCountry(countryPopulation[y][x], y, x);

        int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

        for (int[] ints : dir) {
            int ny = y + ints[0];
            int nx = x + ints[1];

            if (ny < 0 || nx < 0
                    || ny >= countryPopulation.length || nx >= countryPopulation.length
                    || Math.abs(countryPopulation[y][x] - countryPopulation[ny][nx]) < L
                    || Math.abs(countryPopulation[y][x] - countryPopulation[ny][nx]) > R
                    || isVisited[ny][nx]) {
                continue;
            }

            searchCountry(isVisited, ny, nx, union);
        }
    }

    public void init() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            countryPopulation = new int[N][N];

            for (int i = 0; i < N; ++i) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; st.hasMoreTokens(); ++j) {
                    countryPopulation[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}

class Union {
    private int totalPopulation;
    private final List<int[]> countryCoordinates = new ArrayList<>();

    public void addCountry(int population, int y, int x) {
        totalPopulation += population;
        int[] coordinates = {y, x};
        countryCoordinates.add(coordinates);
    }

    public int getPopulationAverage() {
        return totalPopulation / countryCoordinates.size();
    }

    public List<int[]> getCountryCoordinates() {
        return countryCoordinates;
    }

    public boolean isValidUnion() {
        return countryCoordinates.size() > 1;
    }
}