


try {
  assert Character.digit('a', 16)==10
  assert false: 'Need explicit cast'
} catch(MissingMethodException e) {

}

// for single char strings, both are the same
assert ((char) "c").class==Character
assert ("c" as char).class==Character

