import torch.nn as nn
import torch.optim as optim
import torch

class SimpleNN(nn.Module):
    def __init__(self):
        super(SimpleNN, self).__init__()
        self.fc1 = nn.Linear(2, 2) # 输出层到隐藏层
        self.fc2 = nn.Linear(2, 1) # 隐藏层到输出层

    def forward(self, x):
        x = torch.relu(self.fc1(x))
        x = self.fc2(x)
        return x

model = SimpleNN()
print(model)

# 随机输入
x = torch.randn(1, 2)

# 前向传播
output = model(x)
print(output)

# 定义损失函数（例如均方误差MSE）
criterion = nn.MSELoss()

# 假设目标值为1
target = torch.randn(1, 1)

# 计算损失
loss = criterion(output, target)
print(loss)

"""
1. 数据准备
- 收集和处理数据，包括清洗、标准和归一化
- 将数据分为训练集、验证集和测试集
2. 定义模型
- 选择模型架构，例如决策树、神经网络等
- 初始化模型参数（权重和偏置） 

3. 选择损失函数

4. 选择优化器

5. 前向传播

6. 计算损失

7. 反向传播

8. 参数更新

9. 迭代优化
重复步骤5-8,直到模型在验证集上的性能不再提升或达到预定的迭代次数

10. 评估和测试

11. 模型调优

12. 部署模型 
"""