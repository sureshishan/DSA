ThreeSum:

Sorting:
Sort the array to facilitate the two pointer approach and remove duplicates efficiently

Outer loop:
Iterate through the loop, fixing one number at a time (numbers[i])
Skip duplicate numbers for the first element

we have used skip logic around 3 times:

Skipping the duplicates for the first element(numbers[i])

why?
If the current numbers[i] is the same as the previous one (numbers[i - 1]), we have already found all triplets that include numbers[i - 1] as the first number
Recomputing with the same number[i] would produce duplicate results

Skipping duplicates for the second element

after finding the valid triplet, the second pointer (left) may point to a number that is the same as the previous pointer
If we do not skip the duplicates that same triplet will be added again

Skipping the duplicates for the third element:
Similarly third pointer may point to the same number repeatedly after finding a triplet
skipping ensures we do not recompute the same triplet.

Time complexity : O(n * n)
Space complexity: O(k) where k is the number of unique triplets stored in the results list