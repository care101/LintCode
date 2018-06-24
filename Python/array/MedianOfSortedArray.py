class Solution:
  """
  @param: A: An integer array
  @param: B: An integer array
  @return: a double whose format is *.5 or *.0
  """
  def findMedianSortedArrays(self, A, B):
    # write your code here
    if len(A) == 0 and len(B) == 0:
      return 0
    temp = []
    indexA = 0
    indexB = 0
    while indexA < len(A) and indexB < len(B):
      if A[indexA] > B[indexB]:
        temp.append(B[indexB])
        indexB += 1
      else:
        temp.append(A[indexA])
        indexA += 1
    while indexA < len(A):
      temp.append(A[indexA])
      indexA += 1
    while indexB < len(B):
      temp.append(B[indexB])
      indexB += 1
    length = len(temp)
    if length % 2:
      return temp[int(length/2)]
    else:
      return (temp[int(length/2)] + temp[int(length/2)-1]) / 2