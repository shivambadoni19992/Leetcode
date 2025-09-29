func findMin(a, b int) int {
    if(a < b) {
        return a;
    }
    return b;
}

func findMax(a, b int) int {
    if(a > b) {
        return a;
    }
    return b;
}


func maxProfit(prices []int) int {

    maxProfit := 0;
    minBuy := int(1e9);

    for _, price := range prices {
        minBuy = findMin(minBuy, price);
        maxProfit = findMax(maxProfit, price - minBuy);
    }
    return maxProfit;


    
}