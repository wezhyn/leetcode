package tree

import (
	"strconv"
	"strings"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

/**
	传入一个包含 null 的满二叉树字符串数组
	Input : [1,null,2,3]
	Output :
		1
    	\
     	2
	   /
     3
*/
func CreateWithNil(nums string, seq string) *TreeNode {
	strs := strings.Split(nums, seq)
	return createWithNil(strs)
}

func createWithNil(nums []string) *TreeNode {
	if len(nums) == 0 || nums[0] == "null" {
		return new(TreeNode)
	}
	root := stringToTreeNode(nums[0])
	maps := map[int]*TreeNode{
		0: root,
	}
	for i, str := range nums[1:] {
		if strings.TrimSpace(str) != "null" {
			parent := maps[i/2]
			cur := stringToTreeNode(str)
			if i&1 == 0 {
				parent.Left = cur
			} else {
				parent.Right = cur
			}
			maps[i] = cur
		}
	}
	return root
}

func stringToTreeNode(str string) (res *TreeNode) {
	res = new(TreeNode)
	if strings.TrimSpace(str) != "null" {
		res.Val, _ = strconv.Atoi(str)
	}
	return
}
