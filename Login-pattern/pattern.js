class UserLogged {
    constructor() {
      if (UserLogged.instance == null) {
        this.logs = []
        UserLogged.instance = this
      }
      return UserLogged.instance
    }
  
    log(message) {
      this.logs.push(message)
      console.log(`LOG: ${message}`)
    }
  
    printLogCount() {
      console.log(`${this.logs.length} Logs`)
    }
  }
  
  const userLogger = new UserLogged()
  Object.freeze(userLogger)
  export default userLogger