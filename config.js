module.exports = {
  production: (process.env.NODE_ENV === 'production'),
  watch : (process.env.NODE_ENV === 'watch'),

  ports: {
    httpServer: 9595,
    devServer: 9393
  }
};
