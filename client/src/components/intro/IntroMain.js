import styled from "styled-components";
import { TypeAnimation } from "react-type-animation";

const IntroMain = () => {
    const introMessage = [
        `가만히 있어도 불안해요.`,
        1000,
        `이직한 회사에서 적응이 힘들어요.`,
        1000,
        `집중력이 떨어져서 고민이에요.`,
        1000,
        `과거의 상처를 잊지 못하겠어요.`,
        1000,
        `잘하고 있는지 확신이 들지 않아요.`,
        1000,
    ];

    return (
        <>
            <NavSize />
            <IntroMainContainer>
                <TypingContainer>
                    <TypeAnimation sequence={introMessage} wrapper="div" speed={0} repeat={Infinity} cursor={true} />
                </TypingContainer>
                <div className="subTitle">이런 고민, 이곳에 탈탈 털어놓으세요.</div>
                <div className="logo">MENTALTAL</div>
                <div className="button">MENTALTAL 둘러보기</div>
            </IntroMainContainer>
        </>
    );
};

export default IntroMain;

const NavSize = styled.div`
    height: 65px;
`;

const IntroMainContainer = styled.div`
    background-color: var(--green);
    width: 100%;
    /* height: 1080px; */
    height: 840px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    color: var(--white);
    font-family: "Nanum Gothic", sans-serif;

    .subTitle {
        /* height: 100px; */
        padding-top: 15px;
        font-size: 27px;
        font-weight: var(--font-bold);
    }

    .logo {
        font-size: 91.42px;
        padding: 40px 0 60px 0;
    }

    .button {
        background-color: white;
        color: var(--green);
        font-size: 18px;
        font-weight: var(--font-bold);
        border-radius: 50px;
        padding: 15px 30px;
    }
`;

const TypingContainer = styled.div`
    font-size: 22px;

    .cursor.blink {
        animation: blink 0.8s ease-in-out infinite;
    }
`;
