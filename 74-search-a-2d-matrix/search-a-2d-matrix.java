class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int columns = matrix[0].length;
        int start = 0, end = rows * columns - 1;

        while(start <= end) {
            int mid = (start + end) /2;
            int row = mid / columns;
            int column = mid % columns;
            int midEle = matrix[row][column];
            // System.out.println(midEle);
            if(midEle == target) return true;
            if(midEle < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}

// 1 2 3
// 4 5 6
// 7 8 9  search = 6
// 8 / 2 = 4
// start = 5 
// end = 8 mid = 13/2 6

// 1 2 3 4 5 6 7 8 9 

// mid = 9 / 2 = 4 

// row = 4 / 3 = 1
// col = 4 %3 = 1
// start = mid + 1
// end = n-1

// 1 3 5 7
// 10 11 16 20
// 23 30 34 60

