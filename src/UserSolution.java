import java.util.*;

class Update implements Comparable<Update>{
	int index;
	int value;
	public Update(int index, int value) {
		this.index = index;
		this.value = value;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Update(index, value); 
	}
	
	// index가 같으면 같은 객체로 인식
	@Override
	public int compareTo(Update o) {
		return Integer.compare(this.index, o.index);
	}
}

class UserSolution
{
	StringBuilder sb = new StringBuilder();
	// int배열을 저장하는 리스트 (최대  10 + 5000)
	List<int[]> lists;
	// 리스트 이름, 리스트 번호 맵
	Map<String, Integer> listNumberMap;
	// 리스트 이름을 키로 하고, 각 리스트의 변화된 상태(인덱스, value)를 저장하는 트리셋을 저장하는 맵
	Map<String, TreeSet<Update>> listUpdatesMap;
	
	public void init()
	{
		lists = new ArrayList<>();
		listNumberMap = new HashMap<>();
		listUpdatesMap = new HashMap<>();
	}

	public void makeList(char mName[], int mLength, int mListValue[])
	{
		String listName = toString(mName);;
		listNumberMap.put(listName, lists.size());
		listUpdatesMap.put(listName, new TreeSet<>());
		lists.add(mListValue);
	}

	public void copyList(char mDest[], char mSrc[], boolean mCopy)
	{
		String listName = toString(mSrc);			// src리스트 이름
		int listNum = listNumberMap.get(listName);	// src리스트 번호
		String newListName = toString(mDest);
		listNumberMap.put(newListName, listNum);
		if (!mCopy) {
			listUpdatesMap.put(newListName, listUpdatesMap.get(listName));
		}
		else {	
			// 깊은 복사라면 리스트 상태를 저장하는 트리셋을 복사하여 저장
			TreeSet<Update> newUpdatesSet = new TreeSet<>();
			TreeSet<Update> updatesSet = listUpdatesMap.get(listName);
			updatesSet.forEach(update -> {
				try {
					newUpdatesSet.add((Update)update.clone());
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			});
			listUpdatesMap.put(newListName, newUpdatesSet);
		}
	}

	public void updateElement(char mName[], int mIndex, int mValue)
	{
		String listName = toString(mName);
		int[] list = lists.get(listNumberMap.get(listName));
		TreeSet<Update> updates = listUpdatesMap.get(listName);
		
		
		Update update = new Update(mIndex, mValue);
		updates.add(update);
	}

	private String toString(char[] mName) {
		sb.setLength(0);
		for (int i = 0; i < 20; i++) { 
			if (mName[i] == '\0') break;
			sb.append(mName[i]);
		}
		return sb.toString();
	}

	public int element(char mName[], int mIndex)
	{
		String listName = toString(mName);
		int[] list = lists.get(listNumberMap.get(listName));
		TreeSet<Update> updates = listUpdatesMap.get(listName);
		
		if (updates == null) {
			// 얕은 복사된 리스트 데이터 반환
			return list[mIndex];
		}
		else {
			// 깊은 복사된 리스트 데이터 반환
			Update update = updates.ceiling(new Update(mIndex, 0));
			if (update != null && update.index == mIndex) {
				return update.value;
			}
			else return list[mIndex];
		}
	}
}