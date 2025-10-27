struct SortingStruct;

/**
 * Sorted Squared Array - You are given an array of 
 * Integers in which each subsequent value is not 
 * less than the previous value. Write a function 
 * that takes this array as an input and returns a 
 * new array with the squares of each number sorted 
 * in ascending order.
 */

impl SortingStruct {
    fn sorted_squarred_array_method1(arr: &[i32]) -> Vec<i32> {
        let mut new_arr = Vec::new();

        for element in arr.iter() {
            new_arr.push(element.pow(2));
        }

        new_arr = SortingStruct::bubble_sort_algorithm(&mut new_arr);
        new_arr
    }

    fn sorted_squarred_array_method2(arr: &[i32]) -> Vec<i32> {
        let mut new_arr = Vec::new();

        let mut pointer_left: usize = 0;
        let mut pointer_right: usize = arr.len() - 1;

        for _element in arr.iter() {
            let squared_left = arr[pointer_left].pow(2);
            let squared_right = arr[pointer_right].pow(2);

            if squared_left < squared_right {
                new_arr.push(squared_left);
                pointer_left += 1;
            } else {
                new_arr.push(squared_right);
                if pointer_right > 0 {
                    pointer_right -= 1;
                }
            }
        }

        new_arr
    }

    fn bubble_sort_algorithm(arr: &mut [i32]) -> Vec<i32> {
        let size = arr.len();

        for i in 0..size - 1 {
            for j in 0..size - i - 1 {
                if arr[j] > arr[j + 1] {
                    let temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr.to_vec()
    }
}

fn main() {
    let arr = [5, 4, 3, 2, 1, 0];

    let output1 = SortingStruct::sorted_squarred_array_method1(&arr);
    let output2 = SortingStruct::sorted_squarred_array_method2(&arr);

    println!("{:?}", output1);
    println!("{:?}", output2);
}