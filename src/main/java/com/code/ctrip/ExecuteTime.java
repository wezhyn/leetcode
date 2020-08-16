package com.code.ctrip;

/**
 * 66.6
 * 主要原因应该是输入的合法性检验上
 * 只检验了 父节点含有子节点而子节点未初始化
 * 还应该验证 父节点无子节点，而子节点却存在
 *
 * @author wezhyn
 * @since 08.15.2020
 */

import java.util.*;
import java.util.stream.Collectors;

public class ExecuteTime {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            try {
                WorkflowNode node = WorkflowNode.load(cin.nextLine());
                System.out.println(maxTime(node, 0));
            } catch (Exception e) {
                System.out.println(-1);
            }
        }
    }

    private static int maxTime(WorkflowNode node, int currentConsume) {
        int m = currentConsume;
        if (!node.initialised) {
            return -1;
        }
        if (node.nextNodes == null) {
            return currentConsume;
        }
        for (WorkflowNode nextNode : node.nextNodes) {
            final int nextNodeTime = maxTime(nextNode, currentConsume + nextNode.timeoutMillis);
            if (nextNodeTime == -1) {
                return -1;
            }
            m = Math.max(m, nextNodeTime);
        }
        return m;
    }
}

class WorkflowNode {
    String nodeId;
    int timeoutMillis;
    List<WorkflowNode> nextNodes;
    boolean initialised;

    public WorkflowNode(String nodeId, int timeoutMillis, List<WorkflowNode> nextNodes) {
        this.nodeId = nodeId;
        this.timeoutMillis = timeoutMillis;
        this.nextNodes = nextNodes;
    }

    public static WorkflowNode load(String value) {
        // Create head node;
        Map<String, WorkflowNode> map = new HashMap<>();
        WorkflowNode head = new WorkflowNode("HEAD", 0, null);
        map.put(head.nodeId, head);

        for (String nodeValue : value.split("\\|")) {

            String[] properties = nodeValue.split("\\`");
            WorkflowNode node = map.get(properties[0]);
            node.timeoutMillis = Integer.parseInt(properties[1]);
            if (node.initialised || properties.length != 3 || node.timeoutMillis < 0) {
                throw new RuntimeException();
            }


            node.initialised = true;

            // Check next nodes
            if (properties[2].equals("END")) {
                continue;
            }
//            当前节点的子节点
            node.nextNodes = Arrays.stream(properties[2].split(","))
                    .map(p -> new WorkflowNode(p, 0, null))
                    .collect(Collectors.toList());
            node.nextNodes.forEach(p -> map.put(p.nodeId, p));
            map.put(node.nodeId, node);
        }

        return head;
    }
}

