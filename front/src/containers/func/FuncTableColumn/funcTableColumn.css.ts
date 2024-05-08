import { globalStyle, style } from '@vanilla-extract/css'
import vars from '@/styles/variables.css'


export const container = style({
    cursor:'pointer'
})
export const category = style({
    width:'100%',
    minWidth:'40%',
    padding:'4px',
    borderRadius:'5px'
});
export const btnGroupContainer = style({
    width: '30%',
    maxWidth:'50%',
    position: 'absolute',
    backgroundColor:'white',
    borderRadius: '5px',
    boxShadow: 'rgba(50, 50, 93, 0.25) 0px 13px 27px -5px, rgba(0, 0, 0, 0.3) 0px 8px 16px -8px',
    marginTop:'-3%',
    marginLeft: '2%',
    textAlign:'start',
    float: 'left',
    zIndex:3,

})
export const btnGroup = style({

})

globalStyle(`${btnGroup} div`,{
    padding: '2%'

});
export const elementGroup = style({
    display:'flex',
    minHeight:'30px',
    flexDirection:'column',
    borderRadius:'10px 10px 0 0',
    zIndex:2,
    backgroundColor: vars.color.lightGray,

})
export const option = style({
    display:'flex',
    backgroundColor:'transparent',
    fontWeight: 500,
    border: 'none',
});

export const currCategory = style({

    display:'flex',
    borderRadius:'5px',
    padding: '2px',
    justifyContent: 'space-around',


})
globalStyle(`${elementGroup} > div > p`,{
    margin:0,
    cursor:'pointer'

});
globalStyle(`${btnGroup} > div > p`,{
    fontSize: vars.fontSize.tiny,
    fontWeight: '500',
    color: vars.color.deepGray

});

export const select = style({
    borderRadius:'4px',
    cursor:'pointer',
    padding: '3px',
    margin: '0 0 3px 0',
    ':hover':{
        backgroundColor: 'whitesmoke'
    }
})
export const whitesmoke = style({
    backgroundColor: 'whitesmoke'
})

export const button = style({
    borderRadius:'4px',
    padding:'3px',

})
export const manager = style({
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center'
})

export const createCategory = style({
    display:'flex',
    alignItems: 'center',
})

export const clickBackground=style({

    width:'100vw',
    height:'100vh',
    position:'absolute',
    top:0,
    right:0,
    bottom:0,
    left:0,
    zIndex:1,
})


globalStyle(`${select}>span`, {
    marginRight: vars.space.tiny,
    color: vars.color.deepGray,
    fontWeight: 700
})


globalStyle(`${createCategory}>p`, {
    margin: `0 ${vars.space.tiny} 0 0`,
    fontWeight: 400
})

globalStyle(`${manager}>p`, {
    width:'100%',
    margin: `0 ${vars.space.tiny} 0 0`
})

globalStyle(`${manager}>img`, {
    borderRadius: '50%',
    aspectRatio: 1
})