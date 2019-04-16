package yrt.algorithm;

/*
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
判断数组中是否含有该整数。
 */

/*
解题思路：
1、从矩阵的右上角开始进行判断，如果不相等，进行大小判断；
2、在判断前先对row和column进行判断，看他们是否在范围内，如果不再范围内，说明该矩阵中不存在目标值；如果在范围内，接着进行大小判断。
3、如果目标值小于该值，则目标值小于列中该值以下的所有元素，所以不再判断该列，column--;如果目标值大于该值，则目标值大于行中该值以
前的所有元素，所以不再判断改行，row++;
4、循环，知道找到目标值或者出界，不存在目标值。
 */

public class Find {
    public boolean find(int target,int[][] array){
        //判断输入的数组是否正确
        if(array.length == 0 || array[0].length == 0){
            return false;
        }
        int row = 0;
        int column = array[0].length - 1;
        int temp = array[row][column];

        while(target != temp){
            if(column > 0 && row < array.length - 1){
                if(target < temp){
                    column--;
                }else {
                    row++;
                }
                temp = array[row][column];
            } else {
                return false;
            }
        }
        return true;
    }
}
