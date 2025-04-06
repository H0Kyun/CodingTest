function solution(clothes) {
    const clothMap = new Map();
    
    for (let i = 0; i < clothes.length; ++i) {
        if (clothMap.has(clothes[i][1])) {
            clothMap.set(clothes[i][1], clothMap.get(clothes[i][1]) + 1);
        } else {
            clothMap.set(clothes[i][1], 1);
        }
    }
    return Array.from(clothMap.values()).reduce((accumulator, value) => 
        accumulator * ++value
    , 1) - 1;
}