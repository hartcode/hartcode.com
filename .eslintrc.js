module.exports = {
  extends: 'standard',
  parserOptions: {
    ecmaFeatures: {
      jsx: true
    }
  },
  plugins: ['standard', 'promise', 'react', 'jsx', 'jsx-a11y', 'import'],
  globals: {
    fetch: false,
    describe: false,
    it: false,
    alert: false,
    ga: false
  },
  rules: {
    'react/jsx-uses-react': 'error',
    'react/jsx-uses-vars': 'error',
    'space-before-function-paren': 'off'
  }
}
