class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
    int sq = 0, cr = 0, sz = students.length;

    for (int student : students) {
        if (student == 0) {
            cr++;
        } else {
            sq++;
        }
    }

    int i;
    for (i = 0; i < sz; i++) {
        if (sandwiches[i] == 0) {
            if (cr > 0) {
                cr--;
            } else {
                break;
            }
        } else {
            if (sq > 0) {
                sq--;
            } else {
                break;
            }
        }
    }

    
    return sz - i;
}
}