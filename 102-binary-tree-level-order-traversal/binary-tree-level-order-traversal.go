/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func levelOrder(root *TreeNode) [][]int {
    queue := []*TreeNode{root}

    var result [][]int
    if root == nil {
        return result
    }

    for len(queue) > 0 {
        nodes :=  len(queue)
        level := make([]int, 0, nodes)

        for i := 0; i < nodes; i++ {
            curr := queue[0]
            queue = queue[1:]
            level = append(level, curr.Val)
            if curr.Left != nil {
                queue = append(queue, curr.Left)
            }
            if curr.Right != nil {
                queue = append(queue, curr.Right)
            }
        }
        result = append(result, level)


    }
    return result
}