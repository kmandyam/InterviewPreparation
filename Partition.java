// NOTE: this is just a sketch of what I would do in the problem. I'm not solving it explicitly because it's just a matter
// of implementation after writing the sketch out

// PROBLEM: Write code to partition a linked list around a value x such that all nodes less than x come
// before all nodes greater than or equal to x. If x is contained within the list, the values of x only need to be after
// the elements less than x


// SOLUTION:
  // Maintain two new lists called "less" and "greater". We can iterate through the original list and examine the data
  // of each node to determine which new list it should belong to. At this point we peel off elements from the original
  // linked list one at a time putting them in the correct new list. Then we splice the two lists together.
