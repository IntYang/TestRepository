-- bwriter�� ��׸��� ��� �÷��� ���� �������ÿ�
select *
from board
where bwriter='��׸�';

-- bwriter�� '��׸�'�� bno, btitle,bwriter�� �������ÿ�
select bno, btitle, bwriter
from board
where bwriter='��׸�';

-- bno�� 1���� 10������ �Խù��� �������ÿ�
select bno, btitle, bwriter
from board
where bno between 1 and 10;
-- where bno>=1 and bno<=10;

-- bwriter�� '��'�� �����ϴ� �����ϴ� �Խù��� bno, btitle, bwriter�� �������ÿ�
select bno, btitle, bwriter
from board
where bwriter LIKE '%��%';

--�Խù��� ���� �߿� '����'�� ���ԵǾ� �ִ� �Խù��� ��ȣ, ����,�۾����� �������ÿ�
select bno, btitle, bwriter
from board
where btitle LIKE '%����%';

--�Խù��� ����,���� �߿� '�ڹ�'�� ���ԵǾ� �ִ� �Խù��� ��ȣ, ����,�۾���, ������ �������ÿ�
select bno, btitle, bwriter,bcontent
from board
where btitle LIKE '%�ڹ�%' or bcontent LIKE '%�ڹ�%';

-- �۾��̰� '���ڹ�', '��浿' ,'�����' �� �Խù��� ��ȣ, ����, �۾��̸� �������ÿ�
select bno, btitle, bwriter
from board
where bwriter IN('���ڹ�', '��浿' , '�����');
-- where bwriter='���ڹ�' or bwriter='��浿' or bwriter='�����';

-- ÷�������� ���� �Խù��� �������ÿ�
select *
from board
where boriginalfilename is null;
-- ����: null���� �񱳿����� =�� ���� �ȵ�

-- ÷�������� �ִ� �Խù��� �������ÿ�
select *
from board
where boriginalfilename is not null; -- <> �ٸ��İ� ����� ��

-- �Խù��� �ۼ��� ����� �̸��� �������ÿ�(�ߺ� �����ϰ�=> "distinct")
select distinct bwriter from board;

-- �Խñ��� �� ��¥�� 2016���� �Խñ��� �������ÿ�.
select *
from board
-- where '2016.01.01' <= bdate and bdate <='2016.12.31';
where bdate between '2016.01.01' and '2016.12.31';

-- bno->��ȣ, btitle->����, bwriter->�۾��� �� �÷� �̸��� �����Ͽ� �������ÿ�
select bno as ��ȣ, btitle as ����, bwriter �۾��� --  as�� ������ �����ϴ�, ��� �¿����� �̸��ٲ�� �Ѵ�
from board;

/*
  ����
*/

-- �Խù��� ��ȣ�� �������� �ø��������� �������ÿ�
select * 
from board
order by bno asc; --  �����ص� �⺻������ asc

-- 2017�⿡ �ۼ��� �Խù��� ��ȣ�� �������� ������������ �������ÿ�
select *
from board
where bdate between '2017.01.01' and '2017.12.31'
order by bno desc;

-- �۾��̸� �������� 1�� �ø����������ϰ� �� ��¥�� �������� 2�� ������������ �Ͻÿ�
select *
from board
order by bwriter, bdate desc;

/* 
  ����¡ ó�� : �� �������� ������ �� �ִ� ��
  rownum : ���� ������ ���̽� ��� ��ȣ�� �ƴ϶� select�ϸ鼭 ��ȣ�� �Ű��� ��
*/
-- ����Ǿ� �ִ� ������� �� ��ȣ �ű��
select rownum, bno, btitle, bwriter, bdate, bhitcount
from board;

-- ���� �� �� ��ȣ �ű��
select rownum, bno, btitle, bwriter, bdate, bhitcount
from (select rownum, bno, btitle, bwriter, bdate, bhitcount from board order by bno desc); -- ���� ���� : select ���� �� select, ���������� ���̺� �������� ���⵵ ��


-- Ư�� ���ȣ ���ϸ� ��������(Top n(������ ���� n��)�� ��������)
select rownum, bno, btitle, bwriter, bdate, bhitcount
from (select rownum, bno, btitle, bwriter, bdate, bhitcount from board order by bno desc) -- ���� ���� : select ���� �� select, ���������� ���̺� �������� ���⵵ ��
where rownum <=10;
--where rownum >=10; ������ � �� �����;� �� �� ��

-- ���� �� ��ȣ�� �� �� ��ȣ ������ �Խù� ��������*****
select r,bno, btitle, bwriter, bdate, bhitcount
from(
  select rownum as r, bno, btitle, bwriter, bdate, bhitcount
  from (select rownum, bno, btitle, bwriter, bdate, bhitcount from board order by bno desc) -- ���� ���� : select ���� �� select, ���������� ���̺� �������� ���⵵ ��
  --where rownum <=(pageNo*rowsPerPage)
   where rownum <=(2*10)
)
--where r>=((pageNo-1)*rowsPerPage + 1);
where r>=((2-1)*10 + 1);

/*
  �� �� ���ϱ�
*/
-- ��ü �� �� ���ϱ�
select count (*) from board;

-- bno ���� (bno �� ���� �ƴ� �͵�)
select count(bno) from board;

-- boriginalfilename ���� (  boriginalfilename �� ���� �ƴ� �͵�)
select count(boriginalfilename) from board;

-- Ư�� ���ǿ� �´� �� �� ���ϱ�
select count(*) from board where bwriter <> 'ȫ�浿';

