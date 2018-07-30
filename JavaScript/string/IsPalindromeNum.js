/**
 * @param num: a positive number
 * @return: true if it's a palindrome or false
 */
const isPalindrome = function (num) {
    let s = num.toString();
    for (let i = 0; i < s.length / 2; i++) {
        if (s[i] != s[s.length - 1 - i]) {
            return false;
        }
    }
    return true;
}