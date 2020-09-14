package tree

func inorderTraversal(root *TreeNode) []int {
	//	向堆中持续添加最左边的元素，添加完毕后取出最左端元素，即当前树中最左端
	//	操作，即执行了左操作，在重复如上步骤
	stack, left, results := []*TreeNode{}, root, []int{}
	for len(stack) != 0 || left != nil {
		for left != nil {
			stack = append(stack, left)
			left = left.Left
		}
		left = stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		results = append(results, left.Val)
		left = left.Right
	}
	return results

}
