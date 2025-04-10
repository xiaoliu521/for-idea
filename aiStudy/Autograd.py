import torch

x = torch.randn(2, 2, requires_grad=True)
print(x)

y = x + 2
z = y * y * 3
out = z.mean()

print(out)

out.backward()
print(x.grad)