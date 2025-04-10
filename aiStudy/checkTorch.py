import torch

print(torch.__version__)

print(torch.cuda.is_available())

x = torch.rand(5, 3)
print(x)

"""
1. 张量（Tensor）：PyTorch的核心数据结构，支持多维数组，并可以在CPU或GPU上进行加速计算
2. 自动求导（Autograd）:自动求导功能，可以轻松计算模型的梯度，便于进行反向传播和优化。
3. 神经网络（nn.module）:PyTorch提供了简单且强大的API来构建神经网络模型，可以方便地进行前向传播和模型定义。
4. 优化器（Optimizers）：使用优化器（如Adam、SGD等）来更新模型的参数，使得损失最小化。
5. 设备（Device）：可以将模型和张量移动到GPU上以加速计算。
"""
a = torch.zeros(2, 3)
print(a)

b = torch.ones(2, 3)
print(b)

c = torch.randn(2, 3)
print(c)

import numpy as np

np_array = np.array([[1, 2], [3, 4]])
tensor_from_np = torch.from_numpy(np_array)
print(tensor_from_np)

device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
d = torch.randn(2, 3, device=device)
print(d)


