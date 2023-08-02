import java.util.*;

class Solution {
    static class Data {
        int start;
        int end;
        int time;
        
        public Data (int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
    
    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;
        int leftConsultants = n - k;
        int[][] waitTimesByConsultantType = new int[k][leftConsultants + 1];
        
        
        System.out.println(n - k);
        
        List<ArrayList<Data>> bookingList = new ArrayList<>();
        for(int i = 0; i < k; ++i) {
            bookingList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < reqs.length; ++i) {
            bookingList.get(reqs[i][2] - 1)
                .add(new Data(reqs[i][0], reqs[i][0] + reqs[i][1], reqs[i][1]));
        }
        
        for(int i = 0; i <= leftConsultants; ++i) {
            for(int j = 0; j < k; ++j) {
                
                List<Data> consultantSchedule = new ArrayList<>();
                
                for(int p = 0; p < bookingList.get(j).size(); ++p) {
                    
                    
                    if(consultantSchedule.size() < i + 1) {
                        consultantSchedule.add(bookingList.get(j).get(p));
                    } else if(consultantSchedule.get(0).end - bookingList.get(j).get(p).start >= 0){
                        
                        waitTimesByConsultantType[j][i] 
                            += consultantSchedule.get(0).end - bookingList.get(j).get(p).start;
                        consultantSchedule.set(
                            0, 
                            new Data(
                                consultantSchedule.get(0).end, 
                                consultantSchedule.get(0).end + bookingList.get(j).get(p).time, 
                                bookingList.get(j).get(p).time
                            )
                        );
                    } else {
                        consultantSchedule.set(
                            0, 
                            new Data(
                                bookingList.get(j).get(p).start, 
                                bookingList.get(j).get(p).end, 
                                bookingList.get(j).get(p).time
                            )
                        );
                    }
                    
                    consultantSchedule.sort(new Comparator<Data>() {
                        @Override
                        public int compare(Data o1, Data o2) {

                            return o1.end - o2.end;
                        }
		            });
                    
                  
                }

            }
        }

        int[] index = new int[k];
        while(--leftConsultants >= 0) {
            int max = 0;
            int lastIndex = -1;
            for(int i = 0; i < k; ++i) {
                if(index[i] + 1 > waitTimesByConsultantType[i].length) {
                    continue;
                }
                
                if(max < waitTimesByConsultantType[i][index[i]] - waitTimesByConsultantType[i][index[i] + 1]) {
                    max = waitTimesByConsultantType[i][index[i]] - waitTimesByConsultantType[i][index[i] + 1];
                    lastIndex = i;
                }
            }
            
            if(lastIndex >= 0) {
                ++index[lastIndex];    
            }
            
        }
        
        for(int i = 0; i < k; ++i) {
            answer += waitTimesByConsultantType[i][index[i]];
        }
        
        return answer;
    }
}