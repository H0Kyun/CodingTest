// 문제 출처: https://www.acmicpc.net/problem/17478
#include<iostream>

using namespace std;

string underBar(int count) {
		if (count == 0) return "";
		string s = "____";
		return s + underBar(--count);
	}
void whatIsRecursiveFunction(int number, int count)
{
	cout << underBar(count);
	cout << "\"����Լ��� ������?\"\n";
	if (number == 0) {
		cout << underBar(count);
		cout << "\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"\n";
		cout << underBar(count);
		cout << "��� �亯�Ͽ���.\n";
		return;
	}
	cout << underBar(count);
	cout << "\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.\n" + underBar(count)
		+ "���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.\n" + underBar(count)
		+ "���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"\n";
	whatIsRecursiveFunction(--number, count + 1);
	cout << underBar(count);
	cout << "��� �亯�Ͽ���.\n";
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int number;
	cin >> number;

	cout << "��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.\n";
	whatIsRecursiveFunction(number, 0);

}